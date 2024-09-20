package com.practice.demo.config;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspactConfig {

    @Before(value = "execution(* com.practice.demo.controller.HomeController.*(..))")
    public void loggMyAspactOnControllerBefore(JoinPoint point){
        System.out.println("Before : "+ point);
    }

    @After(value = "execution(* com.practice.demo.controller.HomeController.get*(..))")
    public void loggMyAspactOnControllerAfter(JoinPoint point){
        System.out.println("After : "+ point);
    }
}
