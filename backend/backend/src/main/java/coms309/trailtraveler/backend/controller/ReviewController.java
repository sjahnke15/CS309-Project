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
import coms309.trailtraveler.backend.repository.ReviewRepository;
import coms309.trailtraveler.backend.repository.TrailRepository;
import coms309.trailtraveler.backend.repository.UserRepository;
import coms309.trailtraveler.backend.service.ReviewService;

@RestController
public class ReviewController {

	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	TrailRepository trailRepository;
	
	@Autowired
	ReviewService rs;
	
	@GetMapping("review/all")
	List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}
	
	@GetMapping("trail/getReviews/{trailID}")
	List<Review> getReviewsByTrailID(@PathVariable int trailID) throws Exception {
		List<Trail> trails = trailRepository.findAll();
		for(int i = 0; i < trails.size(); i++) {
			if(trails.get(i).getId() == trailID) {
				return trails.get(i).getReviews();
			}
		}
		throw new Exception("Trail ID does not exist");
	}
	
	@PostMapping("review/post/{rating}/{text}/{trailID}/{userID}")
	Review postReviewByPath(@PathVariable float rating, @PathVariable String text, @PathVariable int trailID, @PathVariable int userID) throws Exception {
		Review r = new Review();
		r.setRating(rating);
		r.setText(text);
		
		List<Trail> trails = trailRepository.findAll();
		List<User> users = userRepository.findAll();
		
		/* Look for the user associated with the given userID, if found then add the review to the user and save to 
		 * 	the repository. If not, throw an exception. In reality, the userID should always be found because the front end 
		 * 	should only be sending existing userIDs so throwing the exception is really there for debugging purposes. */
		boolean found = false;
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getId() == userID) { 
				users.get(i).addReview(r);
				this.userRepository.save(users.get(i));
				found = true;
			}
		}
		if(!found) throw new Exception("User does not exist");
		
		/* Look for the trail associated with the given trailID, if found then add the review to it and save. 
		 * 	If not found, then throw an exception. In reality, the trailID should always be found because the front end 
		 * 	should only be sending existing trailIDs. */
		for(int i = 0; i < trails.size(); i++) {
			if(trails.get(i).getId() == trailID) {
				trails.get(i).addReview(r);
				this.trailRepository.save(trails.get(i));
				return r;
			}
		}
		throw new Exception("The trail ID does not exist.");
	}
	
	@PostMapping("review/post/{rating}/{text}/{trailName}/{userID}")
	Review postReviewByTrailName(@PathVariable float rating, @PathVariable String text, @PathVariable String trailName, @PathVariable int userID) {
		Review r = new Review();
		r.setRating(rating);
		r.setText(text);
		
		return r;
	}
	
}
