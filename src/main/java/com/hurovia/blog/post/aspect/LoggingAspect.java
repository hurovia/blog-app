package com.hurovia.blog.post.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
    @Before("execution(* com.hurovia.blog.post.controller.Controller.*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        log.info("entering method: {}",joinPoint.getSignature().getName());
    }

    @After("execution(* com.hurovia.blog.post.controller.*(..))")
    public void logAfterController(JoinPoint joinPoint) {
        log.info("exiting method: {}",joinPoint.getSignature().getName());
    }

    @Before("execution(* com.hurovia.blog.post.service.PostService.*(..))")
    public void logBeforeService(JoinPoint jointPoint){
        log.info("entering method {}",jointPoint.getSignature().getName());
    }

    @After("execution(* com.hurovia.blog.post.service.PostService.*(..))")
    public void logAfterService(JoinPoint joinPoint){
        log.info("exiting method {}",joinPoint.getSignature().getName());
    }

    @AfterThrowing(
        pointcut = "execution(* com.hurovia.blog.post.service.PostService.*(..))",
            throwing = "serviceException"
    )
    public void handleException(Exception serviceException) {
        log.error("Encountered Exception: {}",serviceException.getMessage());
    }

}
