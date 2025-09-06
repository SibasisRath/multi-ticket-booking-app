package com.remock.userService.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.remock.userService.dto.UserEntityDto;
import com.remock.userService.entities.UserEntity;
import com.remock.userService.repositories.UserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	// @Autowired
	UserRepository repository;

	public UserService(UserRepository userRepository) {
		this.repository = userRepository;
    }

	public String addingUser(UserEntityDto dto) {

		log.info("Inside the add user service method.");
		UserEntity entity = new UserEntity();
		if (dto.getPhone()==null) {
			return ("{\"status\": \"enter phone number\"}");
		}
		if (repository.existsByphone(dto.getPhone())) {
			log.info("phone number exists.");
			return ("{\"status\": \"user exists.\"}");
		} else {
			if (dto.getUserId() == null) {
				return ("{\"status\": \"Enter a UserId.\"}");
			}
			if (repository.existsByUserId(dto.getUserId())) {
				return ("{\"status\": \"choose an unique user id.\"}");
			}
			if (dto.getPwd() == null) {
				return ("{\"status\": \"Enter a password.\"}");
			}
			if (dto.getEmail() == null) {
				return ("{\"status\": \"Enter a Email.\"}");
			}
			if (repository.existsByEmail(dto.getEmail())) {
				return ("{\"status\": \"choose an unique Email.\"}");
			} else {
				entity.setUserId(dto.getUserId());
				entity.setUserFirstName(dto.getUserFirstName());
				entity.setUserLastName(dto.getUserLastName());
				entity.setPhone(dto.getPhone());
				entity.setEmail(dto.getEmail());
				entity.setCountry(dto.getCountry());
				entity.setState(dto.getState());
				entity.setDistrict(dto.getDistrict());
				entity.setPwd(dto.getPwd());
				repository.save(entity);
				log.info("user added successfully.");
				return ("{\"status\": \"user added successfully.\"}");
			}
		}

	}

	public String gettingLogin(UserEntityDto dto) {
		log.info("in side getting log in service class method.");
		if (repository.existsByUserId(dto.getUserId())) {
			UserEntity entity = repository.findByUserId(dto.getUserId());
			if (entity.getPwd().equals(dto.getPwd())) {
				return ("{\"status\": \"login successful.\"}");
			} else {
				return ("{\"status\": \"incorrect password.\"}");
			}
		} else {
			return ("{\"status\": \"user does not exist.\"}");
		}
	}

	public Object gettingDetails(String id) {
		if (repository.existsByUserId(id)) {
			log.info("Inside get user details service class method.");
			return (repository.findByUserId(id));
		} else {
			return ("{\"status\": \"User id does not exists.\"}");
		}
	}

	public String profileUpdating(UserEntityDto dto, String id) {
		log.info("Inside the update user service class method.");
		if (repository.existsByUserId(id)) {
			UserEntity entity = repository.findByUserId(id);
			if (dto.getUserFirstName() != null) {
				entity.setUserFirstName(dto.getUserFirstName());
			}
			if (dto.getUserLastName() != null) {
				entity.setUserLastName(dto.getUserLastName());
			}
			if (dto.getCountry() != null) {
				entity.setCountry(dto.getCountry());
			}
			if (dto.getDistrict() != null) {
				entity.setDistrict(dto.getDistrict());
			}
			if (dto.getPwd() != null) {
				entity.setPwd(dto.getPwd());
			}
			if (dto.getEmail() != null) {
				if (repository.existsByEmail(dto.getEmail())) {
					return ("{\"status\": \"updated Email exists.\"}");
				} else {
					entity.setEmail(dto.getEmail());
				}

			}
			if (dto.getPhone() != null) {
				if (repository.existsByphone(dto.getPhone())) {
					return ("{\"status\": \"updated phone number exists.\"}");
				} else {
					entity.setPhone(dto.getPhone());
				}
			}
			if (dto.getState() != null) {
				entity.setState(dto.getState());
			}
			if (dto.getUserId() != null) {
				if (repository.existsByUserId(dto.getUserId())) {
					return ("{\"status\": \"updated UserId exists.\"}");
				} else {
					entity.setUserId(dto.getUserId());
				}
			}

			repository.save(entity);
			return ("{\"status\": \"Profile updated.\"}");
		} else {
			return ("{\"status\": \"Entered id is not correct.\"}");
		}
	}
}
