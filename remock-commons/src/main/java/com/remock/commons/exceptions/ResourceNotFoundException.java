package com.remock.commons.exceptions;

/**
 * Exception thrown when a requested resource is not found
 */
public class ResourceNotFoundException extends BaseBusinessException {

    public ResourceNotFoundException(String message) {
        super(message, "RESOURCE_NOT_FOUND");
    }

    public ResourceNotFoundException(String resourceType, String identifier) {
        super(String.format("%s not found with identifier: %s", resourceType, identifier),
                "RESOURCE_NOT_FOUND", "identifier", identifier);
    }

    public ResourceNotFoundException(String message, String field, String value) {
        super(message, "RESOURCE_NOT_FOUND", field, value);
    }
}
