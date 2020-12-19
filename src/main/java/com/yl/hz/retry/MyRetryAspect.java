package com.yl.hz.retry;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class MyRetryAspect {

    @Pointcut("@annotation(com.yl.hz.retry.MyRetry)")
    private void myRetryMethodCall(){}

    @Around("myRetryMethodCall()")
    public void retry(ProceedingJoinPoint pjp) throws Exception {
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        MyRetry myRetry = method.getAnnotation(MyRetry.class);
        int retryCount = myRetry.retryCount();
        int retryInterval = myRetry.retryInterval();

        Throwable throwable = new RuntimeException();
        for (int i = 0; i < retryCount; i++) {
            try {
                Object proceed = pjp.proceed();
            } catch (Throwable e) {
                throwable = e;
                log.error("method {} execute exception, param:{}", method.getName(), JSON.toJSONString(method.getParameters()));
            }
            Thread.sleep(retryInterval);
        }
        throw new RuntimeException(String.format("method %s execute, Maximum number of retries has been reached, param: %s", method.getName(), throwable.getMessage()));

    }

}
