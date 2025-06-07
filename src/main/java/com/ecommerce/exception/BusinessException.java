package com.ecommerce.exception;

public class BusinessException extends RuntimeException {
    private final String errorCode;
    private final String userMessage;

    public BusinessException(String errorCode, String userMessage) {
        super(userMessage);
        this.errorCode = errorCode;
        this.userMessage = userMessage;
    }

    public BusinessException(ErrorEnum errorEnum) {
        this(errorEnum.getCode(), errorEnum.getMessage());
    }

    public String getErrorCode() { return errorCode; }
    public String getUserMessage() { return userMessage; }
}
