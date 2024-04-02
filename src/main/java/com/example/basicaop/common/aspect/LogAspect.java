package com.example.basicaop.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

    private final String LOG_MESSAGE_FORMAT = "--class:{} - method:{} - message: {}";

    // Puntos de corte para todos los controladores
    @Pointcut("execution(* com.example.basicaop.controller.*Controller.*(..))")
    public void restControllerAllMethods(){}

    // Consejo para antes de la ejecucion de los metodos de los controladores
    @Before("restControllerAllMethods()")
    public void logInitAllRestControllersMethodsAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String message = ">>>>> init controller method";
        log.info(LOG_MESSAGE_FORMAT, className, methodName, message);
    }

    // Consejo para despues de la ejecucion de los metodos de los controladores
    @After("restControllerAllMethods()")
    public void logEndSuccessfullyAllRestControllersMethodsAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String message = "<<<<< Finish controller method";
        log.info(LOG_MESSAGE_FORMAT, className, methodName, message);
    }

    // Puntos de corte para todos los servicios
    @Pointcut("execution(* com.example.basicaop.service.*Service.*(..))")
    public void serviceAllMethods(){}

    // Consejo para antes de la ejecucion de los metodos de los Servicios
    @Before("serviceAllMethods()")
    public void logInitAllServiceMethodsAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String message = "****> init service method";
        log.info(LOG_MESSAGE_FORMAT, className, methodName, message);
    }

    // Consejo para despues de la ejecucion de los metodos de los Servicios
    @After("serviceAllMethods()")
    public void logEndSuccessfullyAllServiceMethodsAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String message = "<**** Finish service method";
        log.info(LOG_MESSAGE_FORMAT, className, methodName, message);
    }

    // Puntos de corte para todos los repositorios
    @Pointcut("execution(* com.example.basicaop.data.repository.*Repository.*(..))")
    public void repositoryAllMethods(){}

    // Consejo para antes de la ejecucion de los metodos de los Servicios
    @Before("repositoryAllMethods()")
    public void logInitAllRepositoryMethodsAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String message = "----> init repository method";
        log.info(LOG_MESSAGE_FORMAT, className, methodName, message);
    }

    // Consejo para despues de la ejecucion de los metodos de los Servicios
    @After("repositoryAllMethods()")
    public void logEndSuccessfullyAllRepositoryMethodsAdvice(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String message = "<---- Finish repository method";
        log.info(LOG_MESSAGE_FORMAT, className, methodName, message);
    }
}
