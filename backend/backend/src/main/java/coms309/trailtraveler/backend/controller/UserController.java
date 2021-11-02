package coms309.trailtraveler.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import coms309.trailtraveler.backend.model.User;
import coms309.trailtraveler.backend.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService us;
	
	@GetMapping("user/all")
	List<User> getAllUsers() {
		return us.retrieveAllUsers();
	}
	
	@GetMapping("user/username/{username}")
	User getUserByUsername(@PathVariable String username) {
		return us.retrieveUserByUsername(username);
	}
	
	@GetMapping("user/email/{email}")
	User getUserByEmail(@PathVariable String email) {
		return us.retrieveUserByEmail(email);
	}
	
	@PostMapping("user/post/{email}/{username}/{password}")
	User postUserByPath(@PathVariable String email, @PathVariable String username, @PathVariable String password) {
		return us.postUser(email, username, password);
	}
}
