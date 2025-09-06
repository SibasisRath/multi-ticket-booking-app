package com.remock.userService;

import com.remock.userService.entities.UserEntity;
import com.remock.userService.repositories.UserRepository;
import com.remock.userService.services.UserService;
import com.remock.userService.dto.UserEntityDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

public class UserServiceTest {
	UserRepository userRepository;
	UserService userService;

	@BeforeEach
	void setup() {
		userRepository = Mockito.mock(UserRepository.class);
		userService = new UserService(userRepository);

	}

	@DisplayName("Junit test for getting user details.")
	@Test
	void testGetUserDetails() throws Exception {
		// given - precondition
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india", "odisha",
				"bolangir", "sss", "sss123");
		BDDMockito.given(userRepository.existsByUserId(userEntity.getUserId())).willReturn(true);
		BDDMockito.given(userRepository.findByUserId(userEntity.getUserId())).willReturn(userEntity);

		// when- action or behavior that we are going to test
		Object userDetails = userService.gettingDetails(userEntity.getUserId());

		// then - verify the output
		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for getting user details.")
	@Test
	void testGetUserDetails1() throws Exception {
		// given - precondition
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india", "odisha",
				"bolangir", "sss", "sss123");
		BDDMockito.given(userRepository.existsByUserId(userEntity.getUserId())).willReturn(false);

		// when- action or behavior that we are going to test
		Object userDetails = userService.gettingDetails(userEntity.getUserId());

		// then - verify the output
		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for user login.")
	@Test
	void testGettingLogin() throws Exception {
		// given - precondition
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india",
				"odisha", "bolangir", "sss", "sss123");
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india", "odisha",
				"bolangir", "sss", "sss123");

		BDDMockito.given(userRepository.existsByUserId(userEntity.getUserId())).willReturn(true);
		BDDMockito.given(userRepository.findByUserId(userEntity.getUserId())).willReturn(userEntity);

		// when- action or behavior that we are going to test
		Object userDetails = userService.gettingLogin(userEntityDto);

		// then - verify the output
		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for user login1.")
	@Test
	void testGettingLogin1() throws Exception {
		// given - precondition
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india",
				"odisha", "bolangir", "sss", "sss12");
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india", "odisha",
				"bolangir", "sss", "sss123");

		BDDMockito.given(userRepository.existsByUserId(userEntity.getUserId())).willReturn(true);
		BDDMockito.given(userRepository.findByUserId(userEntity.getUserId())).willReturn(userEntity);

		// when- action or behavior that we are going to test
		Object userDetails = userService.gettingLogin(userEntityDto);

		// then - verify the output
		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for user login2.")
	@Test
	void testGettingLogin2() throws Exception {
		// given - precondition
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india",
				"odisha", "bolangir", "sss", "sss123");
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india", "odisha",
				"bolangir", "sss", "sss123");

		BDDMockito.given(userRepository.existsByUserId(userEntity.getUserId())).willReturn(false);

		// when- action or behavior that we are going to test
		Object userDetails = userService.gettingLogin(userEntityDto);

		// then - verify the output
		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for Adding user11.")

	@Test
	void testAddingUser11() throws Exception {
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", null, "hello@gmail.com", "india",
				"odisha", "bolangir", "sss", "sss123");

		// when- action or behavior that we are going to test
		Object userDetails = userService.addingUser(userEntityDto);

		// then - verify the output
		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for Adding user.")

	@Test
	void testAddingUser() throws Exception {
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india",
				"odisha", "bolangir", "sss", "sss123");
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india", "odisha",
				"bolangir", "sss", "sss123");

		BDDMockito.given(userRepository.existsByphone(userEntity.getPhone())).willReturn(true);

		// when- action or behavior that we are going to test
		Object userDetails = userService.addingUser(userEntityDto);

		// then - verify the output
		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for Adding user1.")

	@Test
	void testAddingUser1() throws Exception { // given - precondition
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india",
				"odisha", "bolangir", "sss", "sss123");
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india", "odisha",
				"bolangir", "sss", "sss123");

		BDDMockito.given(userRepository.existsByphone(userEntity.getPhone())).willReturn(false);

		// when- action or behavior that we are going to test
		Object userDetails = userService.addingUser(userEntityDto);

		// then - verify the output
		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for Adding user2.")

	@Test
	void testAddingUser2() throws Exception { // given - precondition
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", "1234567890", "lalala", "india", "odisha",
				"bolangir", null, "lalala");
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", "lalala", "india", "odisha",
				"bolangir", null, "lalala");

		BDDMockito.given(userRepository.existsByphone(userEntity.getPhone())).willReturn(false);

		// when- action or behavior that we are going to test
		Object userDetails = userService.addingUser(userEntityDto);

		// then - verify the output
		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for Adding user3.")

	@Test
	void testAddingUser3() throws Exception { // given - precondition
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", "1234567890", "lalala", "india", "odisha",
				"bolangir", "lalala", null);
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", "lalala", "india", "odisha",
				"bolangir", "lalala", null);

		BDDMockito.given(userRepository.existsByphone(userEntity.getPhone())).willReturn(false);

		// when- action or behavior that we are going to test
		Object userDetails = userService.addingUser(userEntityDto);

		// then - verify the output
		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for Adding user4.")

	@Test
	void testAddingUser4() throws Exception { // given - precondition
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", "1234567890", null, "india", "odisha",
				"bolangir", "lalala", "lalala");
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", null, "india", "odisha", "bolangir",
				"lalala", "lalala");

		BDDMockito.given(userRepository.existsByphone(userEntity.getPhone())).willReturn(false);

		// when- action or behavior that we are going to test
		Object userDetails = userService.addingUser(userEntityDto);

		// then - verify the output
		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for Adding user5.")

	@Test
	void testAddingUser5() throws Exception { // given - precondition
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", "1234567890", null, "india", "odisha",
				"bolangir", "lalala", "lalala");
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", null, "india", "odisha", "bolangir",
				"lalala", "lalala");

		BDDMockito.given(userRepository.existsByphone(userEntity.getPhone())).willReturn(false);
		BDDMockito.given(userRepository.existsByUserId(userEntity.getUserId())).willReturn(true);

		// when- action or behavior that we are going to test
		Object userDetails = userService.addingUser(userEntityDto);

		// then - verify the output
		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for Adding user6.")

	@Test
	void testAddingUser6() throws Exception { // given - precondition
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", "1234567890", "lalala", "india", "odisha",
				"bolangir", "lalala", "lalala");
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", "lalala", "india", "odisha",
				"bolangir", "lalala", "lalala");

		BDDMockito.given(userRepository.existsByphone(userEntity.getPhone())).willReturn(false);
		BDDMockito.given(userRepository.existsByEmail(userEntity.getEmail())).willReturn(true);

		// when- action or behavior that we are going to test
		Object userDetails = userService.addingUser(userEntityDto);

		// then - verify the output
		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for updating user details.")
	@Test
	void testProfileUpdating() throws Exception {
		// given - precondition
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india",
				"odisha", "bolangir", "sss", "sss123");
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india", "odisha",
				"bolangir", "sss", "sss123");

		BDDMockito.given(userRepository.existsByUserId("sss")).willReturn(true);
		BDDMockito.given(userRepository.findByUserId("sss")).willReturn(userEntity);
		BDDMockito.given(userRepository.save(userEntity)).willReturn(userEntity);

		Object userDetails = userService.profileUpdating(userEntityDto, userEntityDto.getUserId());

		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for updating user details1.")

	@Test
	void testProfileUpdating1() throws Exception {
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india",
				"odisha", "bolangir", "sss", "sss123");
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india", "odisha",
				"bolangir", "sss", "sss123");

		BDDMockito.given(userRepository.existsByUserId(userEntity.getUserId())).willReturn(false);

		Object userDetails = userService.profileUpdating(userEntityDto, userEntityDto.getUserId());

		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for updating user details2.")

	@Test
	void testProfileUpdating2() throws Exception {
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india",
				"odisha", "bolangir", "sss", "sss123");
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india", "odisha",
				"bolangir", "sss", "sss123");

		BDDMockito.given(userRepository.existsByUserId(userEntity.getUserId())).willReturn(true);
		BDDMockito.given(userRepository.findByUserId(userEntity.getUserId())).willReturn(userEntity);
		BDDMockito.given(userRepository.existsByEmail(userEntityDto.getEmail())).willReturn(true);

		Object userDetails = userService.profileUpdating(userEntityDto, userEntityDto.getUserId());

		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for updating user details3.")

	@Test
	void testProfileUpdating3() throws Exception {
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india",
				"odisha", "bolangir", "sss", "sss123");
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india", "odisha",
				"bolangir", "sss", "sss123");

		BDDMockito.given(userRepository.existsByUserId(userEntity.getUserId())).willReturn(true);
		BDDMockito.given(userRepository.findByUserId(userEntity.getUserId())).willReturn(userEntity);
		BDDMockito.given(userRepository.existsByEmail(userEntityDto.getEmail())).willReturn(false);

		Object userDetails = userService.profileUpdating(userEntityDto, userEntityDto.getUserId());

		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for updating user details4.")

	@Test
	void testProfileUpdating4() throws Exception {
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india",
				"odisha", "bolangir", "sss", "sss123");
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india", "odisha",
				"bolangir", "sss", "sss123");

		BDDMockito.given(userRepository.existsByUserId(userEntity.getUserId())).willReturn(true);
		BDDMockito.given(userRepository.findByUserId(userEntity.getUserId())).willReturn(userEntity);
		userEntityDto.setPhone("0987654321");
		BDDMockito.given(userRepository.existsByphone(userEntityDto.getPhone())).willReturn(true);

		Object userDetails = userService.profileUpdating(userEntityDto, userEntityDto.getUserId());

		Assertions.assertThat(userDetails).isNotNull();
	}

	@DisplayName("Junit test for updating user details5.")

	@Test
	void testProfileUpdating5() throws Exception {
		UserEntityDto userEntityDto = new UserEntityDto(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india",
				"odisha", "bolangir", "ss", "sss123");
		UserEntity userEntity = new UserEntity(1, "sibu", "mishra", "1234567890", "hello@gmail.com", "india", "odisha",
				"bolangir", "sss", "sss123");

		BDDMockito.given(userRepository.existsByUserId(userEntity.getUserId())).willReturn(true);
		BDDMockito.given(userRepository.findByUserId(userEntity.getUserId())).willReturn(userEntity);
		BDDMockito.given(userRepository.existsByUserId(userEntityDto.getUserId())).willReturn(false);
		userEntity.setUserId("ss");

		Object userDetails = userService.profileUpdating(userEntityDto, "sss");

		Assertions.assertThat(userDetails).isNotNull();
	}

}
