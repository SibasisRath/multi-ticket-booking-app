package com.remock.commons.utils;

/**
 * Common constants used across Remock microservices
 */
public final class Constants {

    private Constants() {} // Prevent instantiation

    // API Response Messages
    public static final String SUCCESS_MESSAGE = "Operation completed successfully";
    public static final String CREATE_SUCCESS = "Resource created successfully";
    public static final String UPDATE_SUCCESS = "Resource updated successfully";
    public static final String DELETE_SUCCESS = "Resource deleted successfully";

    // Error Messages
    public static final String RESOURCE_NOT_FOUND = "Resource not found";
    public static final String RESOURCE_ALREADY_EXISTS = "Resource already exists";
    public static final String INVALID_INPUT = "Invalid input provided";
    public static final String UNAUTHORIZED_ACCESS = "Unauthorized access";

    // Validation Messages
    public static final String PHONE_INVALID = "Invalid phone number format";
    public static final String EMAIL_INVALID = "Invalid email format";
    public static final String PASSWORD_WEAK = "Password does not meet security requirements";

    // Regular Expressions
    public static final String PHONE_REGEX = "^[0-9]{10,15}$";
    public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    // Date Formats
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // Pagination Defaults
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int MAX_PAGE_SIZE = 100;
    public static final int DEFAULT_PAGE_NUMBER = 0;
}
