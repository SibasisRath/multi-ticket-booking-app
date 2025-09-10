package com.remock.userService.entities;

import com.remock.commons.entities.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", indexes = {
        @Index(name = "idx_user_id", columnList = "user_id", unique = true),
        @Index(name = "idx_email", columnList = "email", unique = true),
        @Index(name = "idx_phone", columnList = "phone", unique = true)
})
public class UserEntity extends BaseEntity {

    @Column(name = "user_first_name", nullable = false, length = 50)
    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name cannot exceed 50 characters")
    private String userFirstName;

    @Column(name = "user_last_name", length = 50)
    @Size(max = 50, message = "Last name cannot exceed 50 characters")
    private String userLastName;

    @Column(name = "phone", nullable = false, unique = true, length = 15)
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Phone number must be 10-15 digits")
    private String phone;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    private String email;

    @Column(name = "country", length = 50)
    @Size(max = 50, message = "Country name cannot exceed 50 characters")
    private String country;

    @Column(name = "state", length = 50)
    @Size(max = 50, message = "State name cannot exceed 50 characters")
    private String state;

    @Column(name = "district", length = 50)
    @Size(max = 50, message = "District name cannot exceed 50 characters")
    private String district;

    @Column(name = "user_id", nullable = false, unique = true, length = 30)
    @NotBlank(message = "User ID is required")
    @Size(min = 3, max = 30, message = "User ID must be between 3-30 characters")
    private String userId;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password is required")
    private String password;

    public UserEntity() {}

    public UserEntity(String userFirstName, String userLastName, String phone,
                      String email, String country, String state, String district,
                      String userId, String password) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.phone = phone;
        this.email = email;
        this.country = country;
        this.state = state;
        this.district = district;
        this.userId = userId;
        this.password = password;
    }

    // Getters and Setters
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

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
