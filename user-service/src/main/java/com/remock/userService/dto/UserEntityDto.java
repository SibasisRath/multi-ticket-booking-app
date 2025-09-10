package com.remock.userService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.remock.commons.validation.ValidationConstants;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserEntityDto {
    @JsonProperty("user_id")
    @NotBlank(message = "User ID is required", groups = {CreateUser.class, LoginUser.class})
    @Size(min = ValidationConstants.MIN_USER_ID_LENGTH,
            max = ValidationConstants.MAX_USER_ID_LENGTH,
            message = "User ID must be between 3-30 characters")
    private String userId;

    @JsonProperty("first_name")
    @NotBlank(message = "First name is required", groups = CreateUser.class)
    @Size(max = ValidationConstants.MAX_NAME_LENGTH,
            message = "First name cannot exceed 50 characters")
    private String userFirstName;

    @JsonProperty("last_name")
    @Size(max = ValidationConstants.MAX_NAME_LENGTH,
            message = "Last name cannot exceed 50 characters")
    private String userLastName;

    @NotBlank(message = "Phone number is required", groups = CreateUser.class)
    @Pattern(regexp = "^[0-9]{10,15}$", message = ValidationConstants.INVALID_PHONE)
    private String phone;

    @NotBlank(message = "Email is required", groups = CreateUser.class)
    @Email(message = ValidationConstants.INVALID_EMAIL)
    @Size(max = ValidationConstants.MAX_EMAIL_LENGTH,
            message = "Email cannot exceed 100 characters")
    private String email;

    @Size(max = 50, message = "Country name cannot exceed 50 characters")
    private String country;

    @Size(max = 50, message = "State name cannot exceed 50 characters")
    private String state;

    @Size(max = 50, message = "District name cannot exceed 50 characters")
    private String district;

    @NotBlank(message = "Password is required", groups = {CreateUser.class, LoginUser.class})
    @Size(min = ValidationConstants.MIN_PASSWORD_LENGTH,
            message = ValidationConstants.SHORT_PASSWORD, groups = CreateUser.class)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = ValidationConstants.WEAK_PASSWORD, groups = CreateUser.class)
    private String password;

    // Validation Groups
    public interface CreateUser {}
    public interface LoginUser {}

    public UserEntityDto() {}

    // Getters and Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUserFirstName() { return userFirstName; }
    public void setUserFirstName(String userFirstName) { this.userFirstName = userFirstName; }

    public String getUserLastName() { return userLastName; }
    public void setUserLastName(String userLastName) { this.userLastName = userLastName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}