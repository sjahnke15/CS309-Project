package coms309.trailtraveler.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import coms309.trailtraveler.backend.model.Review;
import coms309.trailtraveler.backend.model.Trail;
import coms309.trailtraveler.backend.repository.ReviewRepository;
import coms309.trailtraveler.backend.repository.TrailRepository;

@RestController
public class ReviewController {

	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	TrailRepository trailRepository;
	
	@GetMapping("review/all")
	List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}
	
	@PostMapping("review/post/{rating}/{text}/{trailID}")
	Review postReviewByPath(@PathVariable int rating, @PathVariable String text, @PathVariable int trailID) throws Exception {
		Review r = new Review();
		r.setRating(rating);
		r.setText(text);
		
		List<Trail> trails = trailRepository.findAll();
		Trail t;
		
		for(int i = 0; i < trails.size(); i++) {
			if(trails.get(i).getId() == trailID) {
				t = trails.get(i);
				r.setTrail(t);
				t.addReview(r);
				return r;
			}
		}
		throw new Exception("The trail ID does not exist.");
	}
	
}
