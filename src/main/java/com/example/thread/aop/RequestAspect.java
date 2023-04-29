package com.example.thread.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class RequestAspect {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMapping() {}

    @Around("postMapping()")
    public Object authenticationReset(ProceedingJoinPoint joinPoint) throws Throwable {
        // 시작 시간
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        // 종료 시간
        long end = System.currentTimeMillis();

        log.info("total = {}", (end - start) + " ms");

        return result;
    }

}
