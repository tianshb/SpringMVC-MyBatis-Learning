package com.crow.ssm.exception;

/**
 * Created by CrowHawk on 17/4/7.
 */
public class CustomException extends Exception{
    //异常信息
    public String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
