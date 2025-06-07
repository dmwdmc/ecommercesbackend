package com.ecommerce.exception;

public enum ErrorEnum {
    PRODUCT_NOT_FOUND("1001", "The product does not exist"),
    INSUFFICIENT_STOCK("1002", "Insufficient inventory"),
    TOO_FREQUENTLY("1003", "Too frequent operation"),
    UNAUTHORIZED("401", "unauthorized access");
    private final String code;
    private final String message;

    ErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}