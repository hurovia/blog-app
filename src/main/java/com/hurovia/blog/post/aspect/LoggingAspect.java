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
    public void logBefore(JoinPoint joinPoint) {
        log.info("entering method: {}",joinPoint.getSignature().getName());
    }

    @After("execution(* com.hurovia.blog.post.controller.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("exiting method: {}",joinPoint.getSignature().getName());
    }

    @AfterThrowing(
        pointcut = "execution(* com.hurovia.blog.post.service.*.*(..))",
            throwing = "ex"
    )
    public void handleException(Exception ex) {
        log.error("Encountered Exception: {}",ex.getMessage());
    }

}
