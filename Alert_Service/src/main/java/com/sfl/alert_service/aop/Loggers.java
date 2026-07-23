package com.sfl.alert_service.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class Loggers {

    @Pointcut("execution(* com.sfl.alert_service.service..*(..))")
    public void serviceLayer() {}

    @Pointcut("execution(* com.sfl.alert_service.controller..*(..))")
    public void controllerLayer() {}

    @Before("serviceLayer() || controllerLayer()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Entering: {} with args {}",
                joinPoint.getSignature().toShortString(),
                joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "serviceLayer() || controllerLayer()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("Exiting: {} with result {}",
                joinPoint.getSignature().toShortString(),
                result);
    }

    @Around("serviceLayer() || controllerLayer()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;
        log.info("{} executed in {} ms",
                joinPoint.getSignature().toShortString(),
                duration);
        return proceed;
    }

    @AfterThrowing(pointcut = "serviceLayer() || controllerLayer()", throwing = "ex")
    public void logExceptions(JoinPoint joinPoint, Exception ex) {
        log.error("Exception in {} with cause = {}",
                joinPoint.getSignature().toShortString(),
                ex.getMessage());
    }
}
