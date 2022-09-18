package com.remock.userService.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.remock.userService.dto.UserEntityDto;
import com.remock.userService.services.UserService;

import io.micrometer.core.annotation.Timed;

@RestController
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userService;

	@PostMapping(path = "/user/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed(value = "add_user")
	public ResponseEntity<String> addUser(@RequestBody UserEntityDto dto) {
		log.info("Inside the add user controller.");
		return ResponseEntity.ok(userService.addingUser(dto));
 
	}

	@PostMapping(path = "/user/login")
	@Timed(value = "user_login")
	public ResponseEntity<String> getLogin(@RequestBody UserEntityDto dto) {
		return ResponseEntity.ok(userService.gettingLogin(dto));

	}

	@GetMapping(path = "/user/logout", produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed(value = "logout")
	public ResponseEntity<String> userLogout() {
		log.info("logout succesful.");
		return ResponseEntity.ok("{\"status\": \"Logout successful.\"}");
	}

	@GetMapping(path = "/user/details/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed(value = "get_user_details")
	public Object getDetails(@PathVariable("id") String id) {
		return ResponseEntity.ok(userService.gettingDetails(id));
	}

	@PutMapping(path = "/user/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed(value = "update_user")
	public ResponseEntity<String> profileUpdate(@RequestBody UserEntityDto dto, @PathVariable("id") String id) {
		log.info("Inside the update user controller.");
		return ResponseEntity.ok(userService.profileUpdating(dto, id));
	}
}
