package coms309.trailtraveler.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import coms309.trailtraveler.backend.model.Review;
import coms309.trailtraveler.backend.model.Trail;
import coms309.trailtraveler.backend.model.User;
import coms309.trailtraveler.backend.service.UserService;

/** The UserController class handles http requests from the frontend of the application and depends on the UserService class. **/
@RestController
public class UserController {
	
	/** Instance variable that instantiates a UserService object. **/
	@Autowired
	UserService us;
	
	/** Returns a list of every user in the user repository.
	 * 	@return
	 * 	 The list of all users within the user repository.  **/
	@GetMapping("user/all")
	List<User> getAllUsers() {
		return us.retrieveAllUsers();
	}
	
	/** Returns a user whos username matches the given username. This is used by the frontend for checking login information.
	 * @param username
	 * 	The username that will be compared with every user's username in the repository.
	 * @return
	 * 	The User object in which the given username matches.
	 *  **/
	@GetMapping("user/username/{username}")
	User getUserByUsername(@PathVariable String username) {
		return us.retrieveUserByUsername(username);
	}
	
	/** Returns a user whos username matches the given email. This is used by the frontend for checking login information.
	 * 	@param email
	 * 	 The email that will be compared with every user's email in the repository
	 *  @return 
	 *   The user object associated with the given email.
	 * **/
	@GetMapping("user/email/{email}")
	User getUserByEmail(@PathVariable String email) {
		return us.retrieveUserByEmail(email);
	}
	
	/** Adds a user object with the given parameters to the user repository.
	 *  @param email
	 *   The email of the user to be added to the repository.
	 *  @param username
	 *   The username of the user to be added to the repository.
	 *  @param password
	 *   The password of the user to be added to the repository.
	 *  @return
	 *   If successful, returns the User object of the user just posted to the repository.
	 *  **/
	@PostMapping("user/post/{email}/{username}/{password}")
	User postUserByPath(@PathVariable String email, @PathVariable String username, @PathVariable String password) {
		return us.postUser(email, username, password);
	}
	
	@PostMapping("user/post/{email/username}/{password}/{newPassword}")
	int setNewPassword(@PathVariable String user, @PathVariable String password, @PathVariable String newPassword) {
		return us.newPassword(user, password, newPassword);
	}
	
	@PostMapping("trail/post/{rating}/{text}/{trailName}/{userID}")
	Trail postCompletedTrail(@PathVariable int trailID, @PathVariable String username) throws Exception {
		return us.postCompletedTrail(trailID, username);
	}
}
