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
public class TrailTests {
	
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

	@Test
	public void testRetrieveTrailByName() {
		List<Trail> l = new ArrayList<>();
		
		when(tRepo.findAll()).thenReturn(l);
		when(tRepo.save((Trail)any(Trail.class))).thenAnswer(x -> {
			Trail r = x.getArgument(0);
			l.add(r);
			return null;
		});
		
		Trail t = new Trail();
		t.setId(0);
		t.setName("Trail One");
		Trail t1 = new Trail();
		t1.setId(1);
		t1.setName("Trail Two");
		Trail t2 = new Trail();
		t2.setId(2);
		t2.setName("Trail Three");
		Trail t3 = new Trail();
		t3.setId(3);
		t3.setName("Trail Four");
		Trail t4 = new Trail();
		t4.setId(4);
		t4.setName("Trail Five");
		Trail t5 = new Trail();
		t5.setId(5);
		t5.setName("Trail Six");
		Trail t6 = new Trail();
		t6.setId(6);
		t6.setName("Trail Seven");
		Trail t8 = new Trail();
		t8.setId(7);
		t8.setName("Trail Eight");
		Trail t7 = new Trail();
		t7.setId(8);
		t7.setName("Trail Nine");
		tRepo.save(t);
		tRepo.save(t1);
		tRepo.save(t2);
		tRepo.save(t3);
		tRepo.save(t4);
		tRepo.save(t5);
		tRepo.save(t6);
		tRepo.save(t7);
		tRepo.save(t8);
		
		//Can get all names in database
		assertEquals(0, ts.retrieveTrailByName("Trail One").getId());
		assertEquals(1, ts.retrieveTrailByName("Trail Two").getId());
		assertEquals(2, ts.retrieveTrailByName("Trail Three").getId());
		assertEquals(3, ts.retrieveTrailByName("Trail Four").getId());
		assertEquals(4, ts.retrieveTrailByName("Trail Five").getId());
		assertEquals(5, ts.retrieveTrailByName("Trail Six").getId());
		assertEquals(6, ts.retrieveTrailByName("Trail Seven").getId());
		assertEquals(7, ts.retrieveTrailByName("Trail Eight").getId());
		assertEquals(8, ts.retrieveTrailByName("Trail Nine").getId());
		
		//Name doesn't exist
		assertEquals(null, ts.retrieveTrailByName("Trail None"));
	}
}
