package com.telusko.JobApplication.Logs;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.telusko.JobApplication.service.JobService.updateJob(..)) || execution(* com.telusko.JobApplication.service.JobService.getJob(..))")
    public Object monitorTime(ProceedingJoinPoint pj) throws Throwable {
        long start = System.currentTimeMillis();

        Object obj = pj.proceed();

        long end = System.currentTimeMillis();

        LOGGER.info("Time Taken : " + (end - start) + " Milliseconds");

        return obj;
    }
}
