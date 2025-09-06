package com.remock.commons.validation;

/**
 * Validation constants and messages
 */
public final class ValidationConstants {

    private ValidationConstants() {}

    // Field validation messages
    public static final String REQUIRED_FIELD = "This field is required";
    public static final String INVALID_EMAIL = "Please provide a valid email address";
    public static final String INVALID_PHONE = "Phone number must be 10-15 digits";
    public static final String WEAK_PASSWORD = "Password must contain at least one uppercase letter, one lowercase letter, one number and one special character";
    public static final String SHORT_PASSWORD = "Password must be at least 8 characters long";

    // Size constraints
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final int MAX_NAME_LENGTH = 50;
    public static final int MAX_EMAIL_LENGTH = 100;
    public static final int MIN_USER_ID_LENGTH = 3;
    public static final int MAX_USER_ID_LENGTH = 30;
}
