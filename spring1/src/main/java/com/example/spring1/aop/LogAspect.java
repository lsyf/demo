package com.example.spring1.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LogAspect {

    @Pointcut("@annotation(com.example.spring1.aop.TestAnnotation)")
    public void annotation() {
    }

    @Around(value = "annotation()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        log.info("-----log before-----");
        Object retVal = pjp.proceed();
        log.info("-----log after-----");
        return retVal;
    }


}
