package com.yl.hz.mybatis.model;

import lombok.Data;

@Data
public class MyResult<T> {

    private boolean success;

    private T data;

    private String errorMsg;

    private String errorCode;

    public static <T> MyResult<T> success(T data) {
        MyResult<T> result = new MyResult<>();
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static MyResult error(String errorCode, String errorMsg) {
        MyResult<Object> result = new MyResult<>();
        result.setSuccess(false);
        result.setErrorMsg(errorMsg);
        result.setErrorCode(errorCode);
        return result;
    }

}
