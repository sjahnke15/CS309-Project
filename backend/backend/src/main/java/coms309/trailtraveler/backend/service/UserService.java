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
	
	/*
	 * Retrieves a list of all users from the user repository
	 * @return
	 * A list of users
	 */
	public List<User> retrieveAllUsers() {
		if(uRepo.findAll().size() == 0) { //There are no users
			return null;
		}
		return uRepo.findAll();
	}
	
	/*
	 * Retrieves a user with a username matching the input
	 * @param
	 * A username
	 * @return
	 * A user
	 */
	public User retrieveUserByUsername(String u) {
		List<User> userList = uRepo.findAll();
		User user;
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUsername().equals(u)) {
				user = userList.get(i);
				return user;
			}
		}
		return null;
	}
	
	/*
	 * Retrieves a user with an email matching the input
	 * @param
	 * An email
	 * @return
	 * A user
	 */
	public User retrieveUserByEmail(String e) {
		List<User> userList = uRepo.findAll();
		User user;
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getEmail().equals(e)) {
				user = userList.get(i);
				return user;
			}
		}
		return null;
	}
	
	/*
	 * Posts a user with the given user information to the user repository
	 * @param
	 * An email
	 * @param
	 * A username
	 * @param
	 * A password
	 */
	public User postUser(String e, String u, String p) {
		User user = new User();
		user.setEmail(e);
		user.setUsername(u);
		user.setPassword(p);
		uRepo.save(user);
		return user;
	}
	
	/*
	 * Updates a users information with a new password
	 * @param
	 * A username or email
	 * @param
	 * A current password for the given user
	 * @param
	 * A new password for the given user
	 * @returns
	 * 2 if user is not found, 1 if the current password is incorrect, and a 0 if the password is successfully updated
	 */
	public int newPassword(String i, String p, String nP) {
		User user = retrieveUserByUsername(i);
		if (user.equals(null)) {
			user = retrieveUserByEmail(i);
			if (user.equals(null)) {
				return 2;
			}
		}
		if (!user.getPassword().equals(p)) {
			return 1;
		}
		user.setPassword(nP);
		return 0;
	}
}
