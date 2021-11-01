package coms309.trailtraveler.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms309.trailtraveler.backend.model.User;
import coms309.trailtraveler.backend.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository uRepo;
	
	public List<User> retrieveAllUsers() {
		return uRepo.findAll();
	}
}
