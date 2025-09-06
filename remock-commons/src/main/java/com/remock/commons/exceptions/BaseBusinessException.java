package com.remock.commons.exceptions;

/**
 * Base exception for all business logic exceptions
 */
public abstract class BaseBusinessException extends RuntimeException {
    private String errorCode;
    private String field;
    private String value;

    public BaseBusinessException(String message) {
        super(message);
    }

    public BaseBusinessException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BaseBusinessException(String message, String errorCode, String field, String value) {
        super(message);
        this.errorCode = errorCode;
        this.field = field;
        this.value = value;
    }

    public BaseBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    // Getters
    public String getErrorCode() { return errorCode; }
    public String getField() { return field; }
    public String getValue() { return value; }
}
