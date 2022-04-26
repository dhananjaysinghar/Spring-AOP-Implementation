package com.logger.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Around("@annotation(com.logger.annotations.MeasureTimeExecution)")
    public Object logBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        long t0 = System.nanoTime();
        joinPoint.proceed();
        long t1 = System.nanoTime();

        logger.debug(className + " :: " + methodName +
                " >>>>>>>> Execution Time Taken " + (t1 - t0) + " nanos");
        return null;
    }

    @AfterThrowing(value = "@annotation(com.logger.annotations.HandleException)", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        logger.debug("Exception Occurred in ClassName: {}, MethodName: {}, ErrorMessage: {}", className, methodName, ex.getMessage());
    }
}
