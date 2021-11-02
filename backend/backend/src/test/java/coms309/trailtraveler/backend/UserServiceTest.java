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

import coms309.trailtraveler.backend.model.User;
import coms309.trailtraveler.backend.repository.UserRepository;
import coms309.trailtraveler.backend.service.UserService;

@RunWith(SpringRunner.class)
class UserServiceTest {
	
	@TestConfiguration
	static class UserContextConfiguration {
		
		@Bean
		public UserService uService() {
			return new UserService();
		}
		
		@Bean
		UserRepository getUserRepo() {
			return mock(UserRepository.class);
		}
	}
	
	@Autowired
	private UserService us;
	
	@Autowired
	private UserRepository uRepo;
	
	@Test
	public void testGetAllUsers() {
		List<User> l = new ArrayList<>();
		
		when(uRepo.findAll()).thenReturn(l);
		when(uRepo.save((User)any(User.class))).thenAnswer(x -> {
			User r = x.getArgument(0);
			l.add(r);
			return null;
		});
		
		User u = new User();
		u.setEmail("sjahnke@iastate.edu");
		u.setUsername("sjahnke");
		u.setPassword("Password");
		uRepo.save(u);
		
		User u2 = new User();
		u2.setEmail("test2@iastate.edu");
		u2.setUsername("test2");
		u2.setPassword("Password2");
		uRepo.save(u);
		
		User u3 = new User();
		u3.setEmail("test3@iastate.edu");
		u3.setUsername("test3");
		u3.setPassword("Password3");
		uRepo.save(u);
		
		System.out.println("Email: " + us.retrieveAllUsers().get(0).getEmail());
		
		assertEquals("sjahnke@iastate.edu", us.retrieveAllUsers().get(0).getEmail());
		assertEquals("sjahnke", us.retrieveAllUsers().get(0).getUsername());
		assertEquals("Password", us.retrieveAllUsers().get(0).getPassword());
		
		assertEquals("test2@iastate.edu", us.retrieveAllUsers().get(1).getEmail());
		assertEquals("test2", us.retrieveAllUsers().get(1).getUsername());
		assertEquals("Password2", us.retrieveAllUsers().get(1).getPassword());
		
		assertEquals("test3@iastate.edu", us.retrieveAllUsers().get(2).getEmail());
		assertEquals("test3", us.retrieveAllUsers().get(2).getUsername());
		assertEquals("Password3", us.retrieveAllUsers().get(2).getPassword());
	}
}
