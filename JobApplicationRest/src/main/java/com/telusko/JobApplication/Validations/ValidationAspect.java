package com.telusko.JobApplication.Validations;


import com.telusko.JobApplication.Logs.PerformanceMonitorAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.eclipse.tags.shaded.org.apache.xalan.lib.sql.ObjectArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.telusko.JobApplication.service.JobService.getJob(..)) && args(postID)")
    public Object ValidationAspect(ProceedingJoinPoint pj , int postID) throws Throwable {
        if(postID<0){
            postID = -postID;
        }

        Object obj = pj.proceed(new Object[]{postID});


        return obj;
    }
}
