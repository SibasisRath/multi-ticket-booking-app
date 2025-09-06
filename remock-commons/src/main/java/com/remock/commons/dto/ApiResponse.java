package com.remock.commons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;

/**
 * Standard API response wrapper for all Remock microservices
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private String message;
    private boolean success;
    private T data;
    private LocalDateTime timestamp;
    private String errorCode;
    private ErrorDetail error;

    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(String message, boolean success) {
        this();
        this.message = message;
        this.success = success;
    }

    public ApiResponse(String message, boolean success, T data) {
        this(message, success);
        this.data = data;
    }

    // Static factory methods
    public static <T> ApiResponse<T> success(String message) {
        return new ApiResponse<>(message, true);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(message, true, data);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(message, false);
    }

    public static <T> ApiResponse<T> error(String message, String errorCode) {
        ApiResponse<T> response = new ApiResponse<>(message, false);
        response.setErrorCode(errorCode);
        return response;
    }

    public static <T> ApiResponse<T> error(String message, ErrorDetail error) {
        ApiResponse<T> response = new ApiResponse<>(message, false);
        response.setError(error);
        return response;
    }

    // Getters and Setters
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getErrorCode() { return errorCode; }
    public void setErrorCode(String errorCode) { this.errorCode = errorCode; }

    public ErrorDetail getError() { return error; }
    public void setError(ErrorDetail error) { this.error = error; }
}
