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
public class UserServiceTest {
	
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
		
		assertEquals(null, us.retrieveAllUsers()); //Calling this method on an empty repo should return null.
		
		User u = new User();
		u.setEmail("sjahnke@iastate.edu");
		u.setUsername("sjahnke");
		u.setPassword("Password");
		uRepo.save(u);
		
		User u2 = new User();
		u2.setEmail("test2@iastate.edu");
		u2.setUsername("test2");
		u2.setPassword("Password2");
		uRepo.save(u2);
		
		User u3 = new User();
		u3.setEmail("test3@iastate.edu");
		u3.setUsername("test3");
		u3.setPassword("Password3");
		uRepo.save(u3);
		
		System.out.println("Email: " + us.retrieveAllUsers().get(1).getEmail());
		
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
	
	@Test
	public void testRetrieveUserByUsername() {
		List<User> l = new ArrayList<>();
		
		when(uRepo.findAll()).thenReturn(l);
		when(uRepo.save((User)any(User.class))).thenAnswer(x -> {
			User r = x.getArgument(0);
			l.add(r);
			return null;
		});
		
		assertEquals(null, us.retrieveUserByUsername("Username"));
		
		User u = new User();
		u.setId(0); //We have to manually set the IDs here 
		u.setEmail("sjahnke@iastate.edu");
		u.setUsername("sjahnke");
		u.setPassword("Password");
		uRepo.save(u);
		
		User u2 = new User();
		u2.setId(1);//We have to manually set the IDs here 
		u2.setEmail("test2@iastate.edu");
		u2.setUsername("test2");
		u2.setPassword("Password2");
		uRepo.save(u2);
		
		User u3 = new User();
		u3.setId(2); //We have to manually set the IDs here 
		u3.setEmail("test3@iastate.edu");
		u3.setUsername("test3");
		u3.setPassword("Password3");
		uRepo.save(u3);
		
		//Make sure the correct usernames return the correct ID
		assertEquals(0, us.retrieveUserByUsername("sjahnke").getId());
		assertEquals(1, us.retrieveUserByUsername("test2").getId());
		assertEquals(2, us.retrieveUserByUsername("test3").getId());
		
		//When a username that does not exist is inputed, should return a null object
		assertEquals(null, us.retrieveUserByUsername("test69"));
	}
	
	@Test
	public void testRetrieveUserByEmail() {
		List<User> l = new ArrayList<>();
		
		when(uRepo.findAll()).thenReturn(l);
		when(uRepo.save((User)any(User.class))).thenAnswer(x -> {
			User r = x.getArgument(0);
			l.add(r);
			return null;
		});
		
		assertEquals(null, us.retrieveUserByEmail("email@gmail.com"));
		
		User u = new User();
		u.setId(0); //We have to manually set the IDs here 
		u.setEmail("sjahnke@iastate.edu");
		u.setUsername("sjahnke");
		u.setPassword("Password");
		uRepo.save(u);
		
		User u2 = new User();
		u2.setId(1);//We have to manually set the IDs here 
		u2.setEmail("test2@iastate.edu");
		u2.setUsername("test2");
		u2.setPassword("Password2");
		uRepo.save(u2);
		
		User u3 = new User();
		u3.setId(2); //We have to manually set the IDs here 
		u3.setEmail("test3@iastate.edu");
		u3.setUsername("test3");
		u3.setPassword("Password3");
		uRepo.save(u3);
		
		//Make sure the correct usernames return the correct ID
		assertEquals(0, us.retrieveUserByEmail("sjahnke@iastate.edu").getId());
		assertEquals(1, us.retrieveUserByEmail("test2@iastate.edu").getId());
		assertEquals(2, us.retrieveUserByEmail("test3@iastate.edu").getId());
		
		//When a username that does not exist is inputed, should return a null object
		assertEquals(null, us.retrieveUserByEmail("test69@gmail.com"));
	}
}
