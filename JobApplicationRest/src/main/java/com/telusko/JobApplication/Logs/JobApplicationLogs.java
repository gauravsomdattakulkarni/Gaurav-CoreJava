package com.telusko.JobApplication.Logs;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class JobApplicationLogs {
    private static final Logger LOGGER = LoggerFactory.getLogger(JobApplicationLogs.class);

    //return type , class name , method name , args
    //@Before("execution(* com.telusko.JobApplication.service.JobService.*(..))")
    @After("execution(* com.telusko.JobApplication.service.JobService.updateJob(..)) || execution(* com.telusko.JobApplication.service.JobService.getJob(..))" )
    public void logMethodCallAfter(JoinPoint jp){
        LOGGER.info("Method Exicuation Done : " + jp.getSignature().getName());

    }


    @AfterThrowing("execution(* com.telusko.JobApplication.service.JobService.updateJob(..)) || execution(* com.telusko.JobApplication.service.JobService.getJob(..))" )
    public void logMethodCallAfterException(JoinPoint jp){
        LOGGER.info("Method Has SOme Issue  : " + jp.getSignature().getName());

    }

    @AfterReturning("execution(* com.telusko.JobApplication.service.JobService.updateJob(..)) || execution(* com.telusko.JobApplication.service.JobService.getJob(..))" )
    public void logMethodCallAfterReturalining(JoinPoint jp){
        LOGGER.info("Method Has Returned & Exicuation Done  : " + jp.getSignature().getName());

    }


}
