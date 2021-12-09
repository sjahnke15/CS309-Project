package coms309.trailtraveler.backend;

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
	}
	
	Review r = new Review();
	Trail t = new Trail();
}
