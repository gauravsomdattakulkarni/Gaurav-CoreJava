package com.TaskManager.TaskManager.controller;

import com.TaskManager.TaskManager.entity.Status;
import com.TaskManager.TaskManager.entity.Task;
import com.TaskManager.TaskManager.entity.Users;
import com.TaskManager.TaskManager.service.TaskService;
import com.TaskManager.TaskManager.service.UserAuthService;
import com.TaskManager.TaskManager.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    @Autowired
    UserAuthService userAuthService;

    @Autowired
    UserService userService;

    @GetMapping("/add_task")
    public ModelAndView addTask(ModelAndView mv , RedirectAttributes redirectAttributes , HttpSession session)
    {
        boolean userLoginValidator = userAuthService.userAuthValidator(session);
        if(userLoginValidator){
            mv = new ModelAndView("Layout/App");
            mv.addObject("pageName", "Task/AddTask");
            return mv;
        }else{
            redirectAttributes.addFlashAttribute("error","Session timed out , please login to continue");
            return new ModelAndView("redirect:/user_login");
        }
    }

    @PostMapping("/add_task_success")
    public String addTaskSuccess(Task task, HttpSession session, RedirectAttributes redirectAttributes) {
        boolean userLoginValidator = userAuthService.userAuthValidator(session);
        if (userLoginValidator == true) {
            Users user = (Users) session.getAttribute("logged_in_user");

            // Ensure user is properly set before saving the task
            if (user == null) {
                redirectAttributes.addFlashAttribute("error", "Session timed out , please login to continue.");
                return "redirect:/user_login";
            }

            ZoneId indiaTimeZone = ZoneId.of("Asia/Kolkata");

            // Get the current date at the start of the day in the Indian time zone
            Date today = Date.from(LocalDate.now()
                    .atStartOfDay(indiaTimeZone) // Use India Time Zone
                    .toInstant());

            task.setTask_creation_date(today);
            task.setLast_updated_at(new Date());

            if (task.getStatus() == Status.COMPLETED) {
                task.setTask_completion_date(today);
            }

            // Set the user to the task before saving
            task.setUser(user);

            boolean new_task_add_status = taskService.addTask(task,user);
            if (new_task_add_status == true) {
                redirectAttributes.addFlashAttribute("success", "Task added successfully");
            } else {
                redirectAttributes.addFlashAttribute("error", "Something went wrong, please try again later");
            }
            return "redirect:/add_task";
        } else {
            redirectAttributes.addFlashAttribute("error", "Session timed out, please log in to continue");
            return "redirect:/user_login";
        }
    }


    @GetMapping("/all_tasks")
    public ModelAndView allTasks(ModelAndView mv, HttpSession session, RedirectAttributes redirectAttributes)
    {
        boolean userLoginValidator = userAuthService.userAuthValidator(session);
        if(userLoginValidator){
            Users user = (Users) session.getAttribute("logged_in_user");
            List<Task> tasks = taskService.getAllTasks(user);
            mv = new ModelAndView("Layout/App");
            mv.addObject("pageName", "Task/AllTasks");
            mv.addObject("tasks", tasks);
            return mv;
        }else{
            redirectAttributes.addFlashAttribute("error","Session timed out, please login to continue");
            return new ModelAndView("redirect:/user_login");
        }
    }

    @PostMapping("/delete_task")
    public String deleteTask(@RequestParam("taskId") int taskId, RedirectAttributes redirectAttributes) {
        taskService.deleteTask(taskId);
        redirectAttributes.addFlashAttribute("success", "Task deleted successfully");
        return "redirect:/all_tasks";
    }

    @PostMapping("/change_task_status")
    public String changeTaskStatus(@RequestParam("taskId") int taskId, @RequestParam("status") String taskStatus, RedirectAttributes redirectAttributes, HttpSession session){
        boolean userLoginValidator = userAuthService.userAuthValidator(session);
        if(userLoginValidator) {
            boolean updateTaskStatus = taskService.updateTaskStatus(taskId , taskStatus);
            if(updateTaskStatus) {
                redirectAttributes.addFlashAttribute("success", "Task status updated successfully!");
            }else{
                redirectAttributes.addFlashAttribute("error", "Something went wrong, please try again later");
            }
            return "redirect:/all_tasks";
        }else{
            redirectAttributes.addFlashAttribute("error","Session timed out, please login to continue");
            return "redirect:/user_login";
        }
    }

    @GetMapping("/edit_task/{id}")
    public ModelAndView editTask(@PathVariable("id") int id, ModelAndView mv, HttpSession session, RedirectAttributes redirectAttributes , Model model) {
        boolean userLoginValidator = userAuthService.userAuthValidator(session);
        if(userLoginValidator) {
            Optional<Task> taskDetails = taskService.getTaskById(id);
            if(taskDetails.isPresent()) {
                mv = new ModelAndView("Layout/App");
                model.addAttribute("task",taskDetails.get());
                mv.addObject("pageName", "Task/EditTaskDetails");
                return mv;
            } else {
                redirectAttributes.addFlashAttribute("error", "Task details not found!");
                return new ModelAndView("redirect:/all_tasks");
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Session timed out, please log in to continue");
            return new ModelAndView("redirect:/user_login");
        }
    }

    @PostMapping("/edit_task_success")
    public String editTaskSuccess(@ModelAttribute("task") Task task, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
        boolean userLoginValidator = userAuthService.userAuthValidator(session);

        if (userLoginValidator) {
            Optional<Task> taskDetails = taskService.getTaskById(Math.toIntExact(task.getId()));

            if (taskDetails.isPresent()) {
                Task existingTask = taskDetails.get();

                existingTask.setTitle(task.getTitle());
                existingTask.setDescription(task.getDescription());

                boolean updateTaskDetails = taskService.updateTask(existingTask);

                if (updateTaskDetails) {
                    redirectAttributes.addFlashAttribute("success", "Task details updated successfully");
                } else {
                    redirectAttributes.addFlashAttribute("error", "Failed to update task details. Please try again.");
                }
            } else {
                redirectAttributes.addFlashAttribute("error", "Task not found.");
            }

            return "redirect:/all_tasks";
        } else {
            // Redirect if the user session is invalid
            redirectAttributes.addFlashAttribute("error", "Session timed out, please log in to continue.");
            return "redirect:/user_login";
        }
    }
}
