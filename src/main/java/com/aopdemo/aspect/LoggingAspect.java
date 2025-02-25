package com.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("@annotation(com.aopdemo.annotation.Loggable)")
    public void loggableMethods() {
    }

    @Around("loggableMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("Starting execution of: " + joinPoint.getSignature().getName());
        System.out.println("Method arguments: " + Arrays.toString(joinPoint.getArgs()));

        try {
            Object result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            System.out.println("Completed execution of: " + joinPoint.getSignature().getName());
            System.out.println("Execution time: " + (endTime - startTime) + "ms");
            return result;
        } catch (Exception e) {
            System.out.println("Exception in method: " + joinPoint.getSignature().getName());
            throw e;
        }
    }

    @AfterReturning(pointcut = "loggableMethods()", returning = "result")
    public void logReturnValue(Object result) {
        System.out.println("Method returned: " + result);
    }

    @AfterThrowing(pointcut = "loggableMethods()", throwing = "ex")
    public void logException(Exception ex) {
        System.out.println("Exception thrown: " + ex.getMessage());
    }
}