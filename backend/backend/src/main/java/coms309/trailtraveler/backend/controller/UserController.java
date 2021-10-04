package coms309.trailtraveler.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import coms309.trailtraveler.backend.model.User;
import coms309.trailtraveler.backend.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository UserRepository;
	
	@GetMapping("user/all")
	List<User> getAllUsers() {
		return UserRepository.findAll();
	}
	
	@GetMapping("user/username/{username}")
	User getUserByUsername(@PathVariable String username) {
		List<User> users = UserRepository.findAll();
		User u;
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUsername().equals(username)) {
				u = users.get(i);
				return u;
			}
		}
		return null;
	}
	
	@GetMapping("user/email/{email}")
	User getUserByEmail(@PathVariable String email) {
		List<User> users = UserRepository.findAll();
		User u;
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getEmail().equals(email)) {
				u = users.get(i);
				return u;
			}
		}
		return null;
	}
	
	@PostMapping("user/post/{e}/{n}/{p}")
	User postUserByPath(@PathVariable String e, @PathVariable String n, @PathVariable String p) {
		User u = new User();
		u.setEmail(e);
		u.setUsername(n);
		u.setPassword(p);
		UserRepository.save(u);
		return u;
	}
}
