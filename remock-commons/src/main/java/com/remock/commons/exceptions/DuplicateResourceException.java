package com.remock.commons.exceptions;

/**
 * Exception thrown when trying to create a resource that already exists
 */
public class DuplicateResourceException extends BaseBusinessException {

    public DuplicateResourceException(String message) {
        super(message, "RESOURCE_ALREADY_EXISTS");
    }

    public DuplicateResourceException(String message, String field, String value) {
        super(message, "RESOURCE_ALREADY_EXISTS", field, value);
    }

    // Static factory method for the resource type variant
    public static DuplicateResourceException forResourceType(String resourceType, String field, String value) {
        return new DuplicateResourceException(
                String.format("%s with %s '%s' already exists", resourceType, field, value),
                field,
                value
        );
    }
}