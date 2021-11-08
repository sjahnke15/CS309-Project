package coms309.trailtraveler.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import coms309.trailtraveler.backend.model.Review;
import coms309.trailtraveler.backend.service.ReviewService;

/** The ReviewController class handles http requests from the frontend of the application and depends on the ReviewService class. **/
@RestController
public class ReviewController {
	
	/** Instance variable that instantiates a ReviewService object. **/
	@Autowired
	ReviewService rs;
	
	/** Returns a list of every review in the review repository.
	 * 	@return
	 * 	 The list of all reviews within the review repository.  **/
	@GetMapping("review/all")
	List<Review> getAllReviews() {
		return rs.retrieveAllReviews();
	}
	
	/** Returns a list of review objects that have a matching trailID. This is used to get a list of all reviews for a specific trail.
	 * @param trailID
	 *  The ID of the trail in which we want a list of reviews for.
	 * @return
	 *  The list of reviews associated with the given trail ID.
	 *  **/
	@GetMapping("trail/getReviews/{trailID}")
	List<Review> getReviewsByTrailID(@PathVariable int trailID) {
		return rs.retrieveReviewsByTrailID(trailID);
	}
	
	/** Returns a list of review objects that have a matching userID. This is used to get a list of all reviews that was created by a specific user.
	 * @param userID
	 *  The ID of the user in which we want a list of reviews for.
	 * @return
	 *  The list of reviews associated with the given trail ID.
	 *  **/	@GetMapping("trail/getReviewsByUserID/{userID}")
	List<Review> getReviewsByUserID(@PathVariable int userID) {
		return rs.retrieveReviewsByUserID(userID);
	}
	
	/** Adds a review with the given parameters to the review repository.
	 * @param rating
	 *  The rating of the trail being reviewed.
	 * @param text
	 *  The text of the review.
	 * @param trailID
	 *  A foreign key for the trail that this review was written for. 
	 * @param userID
	 *  A foreign key to the user that wrote this review.
	 * @return
	 *  Returns the Review object created and added to the repository.
	 * @throws Exception
	 *  Throws an exception if the given trailID or userID is invalid.
	 *  **/
	@PostMapping("review/post/{rating}/{text}/{trailID}/{userID}")
	Review postReviewByPath(@PathVariable float rating, @PathVariable String text, @PathVariable int trailID, @PathVariable int userID) throws Exception {
		return rs.postReview(rating, text, trailID, userID);
	}
	
	/** Adds a review with the given parameters to the review repository, but takes a trailname instead of a trailID.
	 * @param rating
	 *  The rating of the trail being reviewed.
	 * @param text
	 *  The text of the review.
	 * @param trailName
	 *  The name of the trail being reviewed.
	 * @param userID
	 *  A foreign key to the user that wrote this review.
	 * @return
	 *  Returns the Review object created and added to the repository.
	 * @throws Exception
	 *  Throws an exception if the given trailID or userID is invalid.
	 *  **/
	@PostMapping("review/postbyname/{rating}/{text}/{trailName}/{userID}")
	Review postReviewByTrailName(@PathVariable float rating, @PathVariable String text, @PathVariable String trailName, @PathVariable int userID) throws Exception {
		return rs.postReviewWithTrailname(rating, text, trailName, userID);
	}
	
}