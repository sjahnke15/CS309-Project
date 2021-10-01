package coms309.trailtraveler.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import coms309.trailtraveler.backend.model.Review;
import coms309.trailtraveler.backend.repository.ReviewRepository;

@RestController
public class ReviewController {

	@Autowired
	ReviewRepository reviewRepository;
	
	@GetMapping("review/all")
	List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}
	
	@PostMapping("review/post/{rating}/{text}")
	Review postReviewByPath(@PathVariable int rating, @PathVariable String text) {
		Review r = new Review();
		r.setRating(rating);
		r.setText(text);
		return r;
	}
	
}
