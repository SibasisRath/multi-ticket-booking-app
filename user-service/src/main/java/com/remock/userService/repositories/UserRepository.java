package com.remock.userService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.remock.userService.entities.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

    // Spring Data automatically implements these derived query methods
    boolean existsByPhone(String phone);
    boolean existsByEmail(String email);
    boolean existsByUserId(String userId);

//    @Query("SELECT u FROM UserEntity u WHERE u.userId = :userId")
//    Optional<UserEntity> findUserByUserId(@Param("userId") String userId);

    // prioritizing derived queries unless a custom JPQL is required.
    Optional<UserEntity> findByUserId(@Param("userId") String userId);

//    @Query("SELECT u FROM UserEntity u WHERE u.userId = :userId AND u.isActive = true")
//    Optional<UserEntity> findActiveUserByUserId(@Param("userId") String userId);

    // prioritizing derived queries unless a custom JPQL is required.
    Optional<UserEntity> findByUserIdAndIsActiveTrue(@Param("userId") String userId);

    @Modifying
    @Query("UPDATE UserEntity u SET u.isActive = true WHERE u.userId = :userId")
    int activateUser(@Param("userId") String userId);

    @Modifying
    @Query("UPDATE UserEntity u SET u.isActive = false WHERE u.userId = :userId")
    int deactivateUser(@Param("userId") String userId);

    @Modifying
    @Query("DELETE FROM UserEntity u WHERE u.userId = :userId")
    void deleteUser(@Param("userId") String userId);

}
