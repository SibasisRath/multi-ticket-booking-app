package com.remock.commons.exceptions;

import java.util.Map;

/**
 * Exception for validation errors
 */
public class ValidationException extends BaseBusinessException {
    private Map<String, String> validationErrors;

    public ValidationException(String message) {
        super(message, "VALIDATION_ERROR");
    }

    public ValidationException(String message, Map<String, String> validationErrors) {
        super(message, "VALIDATION_ERROR");
        this.validationErrors = validationErrors;
    }

    public ValidationException(String message, String field, String value) {
        super(message, "VALIDATION_ERROR", field, value);
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }
}
