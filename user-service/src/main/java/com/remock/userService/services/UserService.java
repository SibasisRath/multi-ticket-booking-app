package com.remock.userService.services;

import com.remock.commons.dto.ApiResponse;
import com.remock.commons.exceptions.DuplicateResourceException;
import com.remock.commons.exceptions.ResourceNotFoundException;
import com.remock.commons.security.CommonSecurityConfig;
import com.remock.commons.utils.Constants;
import com.remock.userService.dto.UserResponseDto;
import com.remock.userService.utils.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.remock.userService.dto.UserEntityDto;
import com.remock.userService.entities.UserEntity;
import com.remock.userService.repositories.UserRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public ApiResponse<UserResponseDto> addUser(UserEntityDto dto) {
        log.info("Adding new user with userId: {}", dto.getUserId());

        validateUniqueConstraints(dto);

        UserEntity entity = userMapper.dtoToEntity(dto);
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));

        UserEntity savedEntity = repository.save(entity);
        log.info("User added successfully with ID: {}", savedEntity.getId());

        UserResponseDto responseDto = userMapper.entityToResponseDto(savedEntity);
        return ApiResponse.success(Constants.CREATE_SUCCESS, responseDto);
    }

    public ApiResponse<String> authenticateUser(UserEntityDto dto) {
        log.info("Authenticating user: {}", dto.getUserId());

//        UserEntity user = repository.findUserByUserId(dto.getUserId())
//                .orElseThrow(() -> new ResourceNotFoundException("User", dto.getUserId()));

        UserEntity user = repository.findByUserId(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User", dto.getUserId()));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            log.warn("Invalid password attempt for user: {}", dto.getUserId());
            throw new ResourceNotFoundException("Invalid credentials");
        }
        log.info("User authenticated successfully: {}", dto.getUserId());
        return ApiResponse.success("Login successful");
    }

    @Transactional(readOnly = true)
    public ApiResponse<UserResponseDto> getUserDetails(String userId) {
        log.info("Fetching details for user: {}", userId);

        UserEntity user = repository.findByUserIdAndIsActiveTrue(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", userId));

        UserResponseDto responseDto = userMapper.entityToResponseDto(user);
        return ApiResponse.success("User details retrieved successfully", responseDto);
    }

    public ApiResponse<UserResponseDto> updateUserProfile(UserEntityDto dto, String userId) {
        log.info("Updating profile for user: {}", userId);

        UserEntity existingUser = repository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", userId));

        validateUpdateConstraints(dto, existingUser);

        userMapper.updateEntityFromDto(existingUser, dto);

        if (dto.getPassword() != null) {
            existingUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        UserEntity updatedUser = repository.save(existingUser);
        log.info("Profile updated successfully for user: {}", userId);

        UserResponseDto responseDto = userMapper.entityToResponseDto(updatedUser);
        return ApiResponse.success(Constants.UPDATE_SUCCESS, responseDto);
    }

    public ApiResponse<String> deactivateUser(String userId) {
        log.info("Deactivating user: {}", userId);

//        int updatedRows = repository.deactivateUser(userId);
//        if (updatedRows == 0) {
//            throw new ResourceNotFoundException("User", userId);
//        }

        log.info("User deactivated successfully: {}", userId);
        //return ApiResponse.success(Constants.DELETE_SUCCESS);
        return ApiResponse.success("User logged out successfully.");
    }

    public ApiResponse<String> deleteUser(String userId) {
        log.info("Permanently deleting user: {}", userId);
        UserEntity user = repository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", userId));

        repository.deleteUser(userId);
        log.info("User permanently deleted from database: {}", userId);
        return ApiResponse.success("User deleted successfully");
    }

    private void validateUniqueConstraints(UserEntityDto dto) {
        if (repository.existsByPhone(dto.getPhone())) {
            throw new DuplicateResourceException("User", "phone", dto.getPhone());
        }

        if (repository.existsByEmail(dto.getEmail())) {
            throw new DuplicateResourceException("User", "email", dto.getEmail());
        }

        if (repository.existsByUserId(dto.getUserId())) {
            throw new DuplicateResourceException("User", "userId", dto.getUserId());
        }
    }

    private void validateUpdateConstraints(UserEntityDto dto, UserEntity existingUser) {
        if (dto.getPhone() != null && !dto.getPhone().equals(existingUser.getPhone())
                && repository.existsByPhone(dto.getPhone())) {
            throw new DuplicateResourceException("User", "phone", dto.getPhone());
        }

        if (dto.getEmail() != null && !dto.getEmail().equals(existingUser.getEmail())
                && repository.existsByEmail(dto.getEmail())) {
            throw new DuplicateResourceException("User", "email", dto.getEmail());
        }

        if (dto.getUserId() != null && !dto.getUserId().equals(existingUser.getUserId())
                && repository.existsByUserId(dto.getUserId())) {
            throw new DuplicateResourceException("User", "userId", dto.getUserId());
        }
    }
}
