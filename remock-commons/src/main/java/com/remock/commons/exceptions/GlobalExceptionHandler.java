package com.remock.commons.exceptions;

import com.remock.commons.dto.ApiResponse;
import com.remock.commons.dto.ErrorDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for all Remock microservices
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFound(ResourceNotFoundException e) {
        log.warn("Resource not found: {}", e.getMessage());

        ErrorDetail error = new ErrorDetail(e.getField(), e.getValue(), e.getMessage());
        ApiResponse<Object> response = ApiResponse.error(e.getMessage(), error);
        response.setErrorCode(e.getErrorCode());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiResponse<Object>> handleDuplicateResource(DuplicateResourceException e) {
        log.warn("Duplicate resource: {}", e.getMessage());

        ErrorDetail error = new ErrorDetail(e.getField(), e.getValue(), e.getMessage());
        ApiResponse<Object> response = ApiResponse.error(e.getMessage(), error);
        response.setErrorCode(e.getErrorCode());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidation(ValidationException e) {
        log.warn("Validation error: {}", e.getMessage());

        ErrorDetail error = new ErrorDetail();
        error.setReason(e.getMessage());
        error.setValidationErrors(e.getValidationErrors());

        ApiResponse<Object> response = ApiResponse.error("Validation failed", error);
        response.setErrorCode(e.getErrorCode());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleMethodArgumentNotValid(
            MethodArgumentNotValidException e) {

        Map<String, String> errors = new HashMap<>();
        BindingResult bindingResult = e.getBindingResult();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        log.warn("Method argument validation failed: {}", errors);

        ErrorDetail error = new ErrorDetail();
        error.setReason("Input validation failed");
        error.setValidationErrors(errors);

        ApiResponse<Object> response = ApiResponse.error("Validation failed", error);
        response.setErrorCode("VALIDATION_ERROR");

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<Object>> handleConstraintViolation(
            ConstraintViolationException e) {

        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            errors.put(violation.getPropertyPath().toString(), violation.getMessage());
        }

        log.warn("Constraint violation: {}", errors);

        ErrorDetail error = new ErrorDetail();
        error.setReason("Constraint validation failed");
        error.setValidationErrors(errors);

        ApiResponse<Object> response = ApiResponse.error("Validation failed", error);
        response.setErrorCode("CONSTRAINT_VIOLATION");

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGenericException(Exception e) {
        log.error("Unexpected error occurred", e);

        ApiResponse<Object> response = ApiResponse.error("An unexpected error occurred");
        response.setErrorCode("INTERNAL_ERROR");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
