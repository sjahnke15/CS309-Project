package coms309.trailtraveler.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import coms309.trailtraveler.backend.model.Review;
import coms309.trailtraveler.backend.service.ReviewService;

@RestController
public class ReviewController {
	
	@Autowired
	ReviewService rs;
	
	@GetMapping("review/all")
	List<Review> getAllReviews() {
		return rs.retrieveAllReviews();
	}
	
	@GetMapping("trail/getReviews/{trailID}")
	List<Review> getReviewsByTrailID(@PathVariable int trailID) {
		return rs.retrieveReviewsByTrailID(trailID);
	}
	
	@GetMapping("trail/getReviewsByUserID/{userID}")
	List<Review> getReviewsByUserID(@PathVariable int userID) {
		return rs.retrieveReviewsByUserID(userID);
	}
	
	@PostMapping("review/post/{rating}/{text}/{trailID}/{userID}")
	Review postReviewByPath(@PathVariable float rating, @PathVariable String text, @PathVariable int trailID, @PathVariable int userID) throws Exception {
		return rs.postReview(rating, text, trailID, userID);
	}
	
	@PostMapping("review/post/{rating}/{text}/{trailName}/{userID}")
	Review postReviewByTrailName(@PathVariable float rating, @PathVariable String text, @PathVariable String trailName, @PathVariable int userID) throws Exception {
		return rs.postReviewWithTrailname(rating, text, trailName, userID);
	}
	
}