package com.example.sample.aop;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestPerformanceAspect {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Around("execution(* com.example.sample.web..*(..)))")
  public Object measureMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    Signature signature = proceedingJoinPoint.getSignature();
    String classAndMethod = signature.getDeclaringType().getSimpleName() + "." + signature.getName() + "=";
    long start = System.nanoTime();
    Object proceedResult = proceedingJoinPoint.proceed();
    logger.info(classAndMethod + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));
    return proceedResult;
  }

}