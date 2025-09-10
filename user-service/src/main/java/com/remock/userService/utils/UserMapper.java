package com.remock.userService.utils;

import com.remock.userService.dto.UserEntityDto;
import com.remock.userService.dto.UserResponseDto;
import com.remock.userService.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity dtoToEntity(UserEntityDto dto) {
        UserEntity entity = new UserEntity();
        entity.setUserId(dto.getUserId());
        entity.setUserFirstName(dto.getUserFirstName());
        entity.setUserLastName(dto.getUserLastName());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setCountry(dto.getCountry());
        entity.setState(dto.getState());
        entity.setDistrict(dto.getDistrict());
        entity.setPassword(dto.getPassword()); // Will be encoded in service
        return entity;
    }

    public UserResponseDto entityToResponseDto(UserEntity entity) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setUserFirstName(entity.getUserFirstName());
        dto.setUserLastName(entity.getUserLastName());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        dto.setCountry(entity.getCountry());
        dto.setState(entity.getState());
        dto.setDistrict(entity.getDistrict());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setIsActive(entity.getIsActive());
        return dto;
    }

    public void updateEntityFromDto(UserEntity entity, UserEntityDto dto) {
        if (dto.getUserFirstName() != null) {
            entity.setUserFirstName(dto.getUserFirstName());
        }
        if (dto.getUserLastName() != null) {
            entity.setUserLastName(dto.getUserLastName());
        }
        if (dto.getCountry() != null) {
            entity.setCountry(dto.getCountry());
        }
        if (dto.getState() != null) {
            entity.setState(dto.getState());
        }
        if (dto.getDistrict() != null) {
            entity.setDistrict(dto.getDistrict());
        }
        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail());
        }
        if (dto.getPhone() != null) {
            entity.setPhone(dto.getPhone());
        }
    }
}