package ir.javatalks.bookstore.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

  @Pointcut("execution(* ir.javatalks.bookstore.controller.BookController.findAllBooks(..))")
  public void controllerMethods() {}

  @Before("controllerMethods()")
  public void logBefore(JoinPoint joinPoint) {
    logger.info("Before executing method: {}", joinPoint.getSignature().getName());
  }

  @AfterReturning(pointcut = "controllerMethods()", returning = "result")
  public void logAfter(JoinPoint joinPoint, Object result) {
    logger.info("After executing method: {}", joinPoint.getSignature().getName());
    logger.info("Result: {}", result);
  }

  @AfterThrowing(pointcut = "controllerMethods()", throwing = "exception")
  public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
    logger.error("Exception in method: {}", joinPoint.getSignature().getName(), exception);
  }

  @Around("controllerMethods()")
  public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();
    Object result = joinPoint.proceed();
    long endTime = System.currentTimeMillis();
    logger.info("Execution time of {}: {} ms", joinPoint.getSignature().getName(), endTime - startTime);
    return result;
  }
}
