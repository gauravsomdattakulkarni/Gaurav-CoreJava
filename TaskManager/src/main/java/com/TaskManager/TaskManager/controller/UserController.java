package com.TaskManager.TaskManager.controller;

import com.TaskManager.TaskManager.entity.Status;
import com.TaskManager.TaskManager.entity.Users;
import com.TaskManager.TaskManager.service.TaskService;
import com.TaskManager.TaskManager.service.UserAuthService;
import com.TaskManager.TaskManager.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserAuthService userAuthService;

    @Autowired
    TaskService taskService;

    @GetMapping("/dashboard")
    public ModelAndView dashboard(ModelAndView mv, HttpSession session, RedirectAttributes redirectAttributes) {
        // Check if the user is authenticated
        boolean userLoginValidator = userAuthService.userAuthValidator(session);

        if (userLoginValidator) {
            // Get logged-in user
            Users user = (Users) session.getAttribute("logged_in_user");

            // Retrieve task counts by status for the user
            long pendingCount = taskService.countTasksByStatusAndUser(Status.PENDING, user);
            long completedCount = taskService.countTasksByStatusAndUser(Status.COMPLETED, user);
            long inProcessCount = taskService.countTasksByStatusAndUser(Status.IN_PROCESS, user);
            long notStartedCount = taskService.countTasksByStatusAndUser(Status.NOT_STARTED, user);
            long onHoldCount = taskService.countTasksByStatusAndUser(Status.ON_HOLD, user);
            long testingCount = taskService.countTasksByStatusAndUser(Status.TESTING, user);
            long underVerificationCount = taskService.countTasksByStatusAndUser(Status.UNDER_VERIFICATION, user);
            long sentForReviewCount = taskService.countTasksByStatusAndUser(Status.SENT_FOR_REVIEW, user);

            // Set view and add counts to the model
            mv = new ModelAndView("Layout/App");
            mv.addObject("pageName", "Dashboard");

            // Add task status counts
            mv.addObject("pendingCount", pendingCount);
            mv.addObject("completedCount", completedCount);
            mv.addObject("inProcessCount", inProcessCount);
            mv.addObject("notStartedCount", notStartedCount);
            mv.addObject("onHoldCount", onHoldCount);
            mv.addObject("testingCount", testingCount);
            mv.addObject("underVerificationCount", underVerificationCount);
            mv.addObject("sentForReviewCount", sentForReviewCount);

            return mv;
        } else {
            // If session has expired, redirect to login
            redirectAttributes.addFlashAttribute("error", "Session timed out, please login to continue");
            return new ModelAndView("redirect:/user_login");
        }
    }

}
