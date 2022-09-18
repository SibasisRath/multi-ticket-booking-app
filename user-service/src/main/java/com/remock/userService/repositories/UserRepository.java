package com.remock.userService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.remock.userService.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	public boolean existsByphone(String phoneDto);

	public UserEntity findByPhone(String phoneDto);

	public boolean existsByUserId(String userId);

	public boolean existsByUserFirstName(String string);

	public UserEntity findByUserId(String id);

	public boolean existsByEmail(String email);

}
