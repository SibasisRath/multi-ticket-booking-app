package com.remock.userService.controllers;

import com.remock.commons.dto.ApiResponse;
import com.remock.userService.dto.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.remock.userService.dto.UserEntityDto;
import com.remock.userService.services.UserService;

import io.micrometer.core.annotation.Timed;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/user")
@Validated
@Tag(name = "User Management", description = "APIs for user registration, authentication and profile management")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed(value = "add_user", description = "Time taken to add a user")
    @Operation(summary = "Register a new user", description = "Creates a new user account with the provided details")
    public ResponseEntity<ApiResponse<UserResponseDto>> addUser(
            @Validated(UserEntityDto.CreateUser.class) @RequestBody UserEntityDto dto) {

        log.info("Received request to add user: {}", dto.getUserId());
        ApiResponse<UserResponseDto> response = userService.addUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping(value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed(value = "user_login", description = "Time taken for user login")
    @Operation(summary = "User login", description = "Authenticates user credentials and provides access")
    public ResponseEntity<ApiResponse<String>> login(
            @Validated(UserEntityDto.LoginUser.class) @RequestBody UserEntityDto dto) {

        log.info("Login request for user: {}", dto.getUserId());
        ApiResponse<String> response = userService.authenticateUser(dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/logout/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed(value = "user_logout", description = "Time taken for user logout")
    @Operation(summary = "User logout", description = "Logs out the current user session")
    public ResponseEntity<ApiResponse<String>> logout(@PathVariable("userId") @NotBlank String userId) {
        log.info("Deactivation request for user: {}", userId);
        ApiResponse<String> response = userService.deactivateUser(userId);
        return ResponseEntity.ok(response) ;
    }

    @GetMapping(value = "/details/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed(value = "get_user_details", description = "Time taken to get user details")
    @Operation(summary = "Get user details", description = "Retrieves detailed information about a specific user")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUserDetails(
            @PathVariable("userId") @NotBlank String userId) {

        log.info("Fetching details for user: {}", userId);
        ApiResponse<UserResponseDto> response = userService.getUserDetails(userId);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/update/{userId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed(value = "update_user", description = "Time taken to update user")
    @Operation(summary = "Update user profile", description = "Updates user profile information")
    public ResponseEntity<ApiResponse<UserResponseDto>> updateProfile(
            @Valid @RequestBody UserEntityDto dto,
            @PathVariable("userId") @NotBlank String userId) {

        log.info("Update request for user: {}", userId);
        ApiResponse<UserResponseDto> response = userService.updateUserProfile(dto, userId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/deactivate/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed(value = "deactivate_user", description = "Time taken to deactivate user")
    @Operation(summary = "Deactivate user", description = "Deactivates a user account (soft delete)")
    public ResponseEntity<ApiResponse<String>> deactivateUser(
            @PathVariable("userId") @NotBlank String userId) {

        log.info("Deleting request for user: {}", userId);
        ApiResponse<String> response = userService.deleteUser(userId);
        return ResponseEntity.ok(response);
    }
}