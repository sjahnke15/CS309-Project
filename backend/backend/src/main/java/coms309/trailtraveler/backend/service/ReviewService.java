package coms309.trailtraveler.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms309.trailtraveler.backend.model.Review;
import coms309.trailtraveler.backend.model.Trail;
import coms309.trailtraveler.backend.model.User;
import coms309.trailtraveler.backend.repository.ReviewRepository;
import coms309.trailtraveler.backend.repository.TrailRepository;
import coms309.trailtraveler.backend.repository.UserRepository;

@Service
public class ReviewService {
	@Autowired
	ReviewRepository rRepo;
	@Autowired 
	TrailRepository tRepo;
	@Autowired
	UserRepository uRepo;
	
	public List<Review> retrieveAllReviews() {
		if(rRepo.findAll().size() == 0) {
			return null;
		}
		return rRepo.findAll();
	}
	
	public List<Review> retrieveReviewsByTrailID(int tid) {
		List<Trail> trailList = tRepo.findAll();
		for(int i = 0; i < trailList.size(); i++) {
			if(trailList.get(i).getId() == tid) {
				return trailList.get(i).getReviews();
			}
		}
		return null;
	}

	public List<Review> retrieveReviewsByUserID(int uid) {
		List<User> userList = uRepo.findAll();
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getId() == uid) {
				return userList.get(i).getReviews();
			}
		}
		return null;
	}
	
	public Review postReview(float r, String t, int tid, int uid) throws Exception {
		Review review = new Review();
		review.setRating(r);
		review.setText(t);
		
		List<Trail> trailList = tRepo.findAll();
		List<User> userList = uRepo.findAll();
		
		/* Look for the user associated with the given userID, if found then add the review to the user and save to 
		 * 	the repository. If not, throw an exception. In reality, the userID should always be found because the front end 
		 * 	should only be sending existing userIDs so throwing the exception is really there for debugging purposes. */
		boolean found = false;
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getId() == uid) { 
				userList.get(i).addReview(review);
				found = true;
			}
		}
		if(!found) throw new Exception("User does not exist");
		
		/* Look for the trail associated with the given trailID, if found then add the review to it and save. 
		 * 	If not found, then throw an exception. In reality, the trailID should always be found because the front end 
		 * 	should only be sending existing trailIDs. */
		for(int i = 0; i < trailList.size(); i++) {
			if(trailList.get(i).getId() == tid) {
				trailList.get(i).addReview(review);
				rRepo.save(review);
				return review;
			}
		}
		throw new Exception("The trail ID does not exist.");
	}

	public Review postReviewWithTrailname(float r, String t, String tName, int uid) throws Exception{
		Review review = new Review();
		review.setRating(r);
		review.setText(t);
		
		List<User> userList = uRepo.findAll();
		List<Trail> trailList = tRepo.findAll();
		
		boolean found = false;
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getId() == uid) { 
				userList.get(i).addReview(review);
				found = true;
			}
		}
		if(!found) throw new Exception("User does not exist");
		
		for(int i = 0; i < trailList.size(); i++) {
			//If we found the trail with name matching the inputed trail name
			if(trailList.get(i).getName().equals(tName)) {
				trailList.get(i).addReview(review);
				rRepo.save(review);
				return review;
			}
		}
		throw new Exception("Trail name does not exist...");
	}
	
}