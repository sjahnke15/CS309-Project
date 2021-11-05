package coms309.trailtraveler.backend;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import coms309.trailtraveler.backend.model.Review;
import coms309.trailtraveler.backend.repository.ReviewRepository;
import coms309.trailtraveler.backend.repository.TrailRepository;
import coms309.trailtraveler.backend.repository.UserRepository;
import coms309.trailtraveler.backend.service.ReviewService;

@RunWith(SpringRunner.class)
public class ReviewServiceTest {

	@TestConfiguration
	static class reviewContextConfiguration {
		
		@Bean
		public ReviewService rService() {
			return new ReviewService();
		}
		
		@Bean
		TrailRepository getTrailRepo() {
			return mock(TrailRepository.class);
		}
		
		@Bean
		UserRepository getUserRepo() {
			return mock(UserRepository.class);
		}
		
		@Bean
		ReviewRepository getReviewRepo() {
			return mock(ReviewRepository.class);
		}
		
	}
	
	@Autowired
	private ReviewService rs;
	
	@Autowired
	private ReviewRepository rRepo;
	
	@Test
	public void testGetAllReviews() {
		List<Review> l = new ArrayList<>();
		
		when(rRepo.findAll()).thenReturn(l);
		when(rRepo.save((Review)any(Review.class))).thenAnswer(x -> {
			Review r = x.getArgument(0);
			l.add(r);
			return r;
		});
		
		//No reviews in the repo returns null
		assertEquals(null, rs.retrieveAllReviews());
		
		Review test1 = new Review();
		test1.setId(0);
		test1.setRating((float) 4.5);
		test1.setText("This was dumb lit");
		rRepo.save(test1);
		
		Review test2 = new Review();
		test2.setId(1);
		test2.setRating((float) 2.0);
		test2.setText("This trail was dumb and stinky");
		rRepo.save(test2);
		
		Review test3 = new Review();
		test3.setId(2);
		test3.setRating((float) 3.0);
		test3.setText("This trail was aight");
		rRepo.save(test3);
		
		Review test4 = new Review();
		test4.setId(3);
		test4.setRating((float) 0);
		test4.setText("This trail needs to be demolished");
		rRepo.save(test4);
		
		Review test5 = new Review();
		test5.setId(4);
		test5.setRating((float) 5.0);
		test5.setText("This was fuckin sick");
		rRepo.save(test5);
		
		//IDs are correct
		assertEquals(test1.getId(), rs.retrieveAllReviews().get(0).getId());
		assertEquals(test2.getId(), rs.retrieveAllReviews().get(1).getId());
		assertEquals(test3.getId(), rs.retrieveAllReviews().get(2).getId());
		assertEquals(test4.getId(), rs.retrieveAllReviews().get(3).getId());
		assertEquals(test5.getId(), rs.retrieveAllReviews().get(4).getId());
		
		//Ratings are correct
		assertEquals(4.5, rs.retrieveAllReviews().get(0).getRating(), 4.5);
		assertEquals(2.0, rs.retrieveAllReviews().get(1).getRating(), 2.0);
		assertEquals(3.0, rs.retrieveAllReviews().get(2).getRating(), 3.0);
		assertEquals(0, rs.retrieveAllReviews().get(3).getRating(), 0);
		assertEquals(5.0, rs.retrieveAllReviews().get(4).getRating(), 5.0);
		
		//Texts are correct
		assertEquals("This was dumb lit", rs.retrieveAllReviews().get(0).getText());
		assertEquals("This trail was dumb and stinky", rs.retrieveAllReviews().get(1).getText());
		assertEquals("This trail was aight", rs.retrieveAllReviews().get(2).getText());
		assertEquals("This trail needs to be demolished", rs.retrieveAllReviews().get(3).getText());
		assertEquals("This was fuckin sick", rs.retrieveAllReviews().get(4).getText());
	}
}
