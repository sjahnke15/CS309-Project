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
import coms309.trailtraveler.backend.model.Trail;
import coms309.trailtraveler.backend.repository.TrailRepository;
import coms309.trailtraveler.backend.service.TrailService;

@RunWith(SpringRunner.class)
public class TrailAverageTest {
	
	@TestConfiguration
	static class TrailContextConfiguration {
		
		@Bean
		public TrailService tService() {
			return new TrailService();
		}
		
		@Bean
		public TrailRepository tRepo() {
			return mock(TrailRepository.class);
		}
	}
	
	@Autowired
	private TrailService ts;
	
	@Autowired 
	TrailRepository tRepo;
	
	@Test
	public void testAverageTrailRating() {
		List<Trail> l = new ArrayList<>();
		
		when(tRepo.findAll()).thenReturn(l);
		when(tRepo.save((Trail)any(Trail.class))).thenAnswer(x -> {
			Trail r = x.getArgument(0);
			l.add(r);
			return null;
		});
		Review r = new Review();
		Review r1 = new Review();
		Review r2 = new Review();
		Review r3 = new Review();
		Review r4 = new Review();
		r.setRating(1);
		r1.setRating(2);
		r2.setRating(3);
		r3.setRating(4);
		r4.setRating(5);
		
		Trail t = new Trail();
		t.setName("LaLaLand");
		tRepo.save(t);
		assertEquals(-1, ts.retrieveTrailRating(t.getName()), 0);
		
		t.addReview(r);
		t.addReview(r2);
		t.addReview(r3);
		t.addReview(r4);
		t.addReview(r1);
		tRepo.save(t);
		assertEquals(3, ts.retrieveTrailRating(t.getName()), 0);
		assertEquals(-2, ts.retrieveTrailRating("Doesnt Exist"), 0);
		
		Review r5 = new Review();
		Review r6 = new Review();
		Review r7 = new Review();
		Review r8 = new Review();
		Review r9 = new Review();
		r5.setRating(6);
		r6.setRating(8);
		r7.setRating(8);
		r8.setRating(6);
		r9.setRating(10);
		t.addReview(r5);
		t.addReview(r6);
		t.addReview(r7);
		t.addReview(r9);
		t.addReview(r8);
		tRepo.save(t);
		
		assertEquals(5.3, ts.retrieveTrailRating(t.getName()), 0);
	}

}
