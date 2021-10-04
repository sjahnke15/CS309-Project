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
	
	@PostMapping("user/post/{n}/{p}")
	User postUserByPath(@PathVariable String n, @PathVariable String p) {
		User u = new User();
		u.setUsername(n);
		u.setPassword(p);
		UserRepository.save(u);
		return u;
	}
}
