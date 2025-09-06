package com.remock.commons.dto;

import java.util.Map;

/**
 * Detailed error information for API responses
 */
public class ErrorDetail {
    private String field;
    private String value;
    private String reason;
    private Map<String, String> validationErrors;

    public ErrorDetail() {}

    public ErrorDetail(String field, String value, String reason) {
        this.field = field;
        this.value = value;
        this.reason = reason;
    }

    // Getters and Setters
    public String getField() { return field; }
    public void setField(String field) { this.field = field; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public Map<String, String> getValidationErrors() { return validationErrors; }
    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
