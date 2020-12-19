package com.yl.hz.retry;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRetry {

    /**
     * 重试次数
     */
    int retryCount() default 3;

    /**`
     * 重试间隔
     */
    int retryInterval() default 100;

}
