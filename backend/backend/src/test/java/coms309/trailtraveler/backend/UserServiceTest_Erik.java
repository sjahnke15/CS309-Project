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
import coms309.trailtraveler.backend.model.Trail;
import coms309.trailtraveler.backend.repository.TrailRepository;
import coms309.trailtraveler.backend.service.TrailService;

@RunWith(SpringRunner.class)
public class UserServiceTest_Erik {
	
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
		
		@Bean
		public TrailService tService() {
			return new TrailService();
		}
		
		@Bean
		TrailRepository getTrailRepo() {
			return mock(TrailRepository.class);
		}
	}
	
	@Autowired
	private UserService uServ;
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private TrailService tServ;
	
	@Autowired
	private TrailRepository tRepo;
	
	@Test
	public void testGetUserByEmail() {
		List<User> uList = new ArrayList<>();
		
		when(uRepo.findAll()).thenReturn(uList);
		when(uRepo.save((User)any(User.class))).thenAnswer(x -> {
			User u = x.getArgument(0);
			uList.add(u);
			return null;
		});
		
		User u1 = new User();
		u1.setEmail("esraman@iastate.edu");
		u1.setUsername("ramanKid");
		u1.setPassword("testPass");
		uRepo.save(u1);
		
		User u2 = new User();
		u2.setEmail("caraman@iastate.edu");
		u2.setUsername("ramanKid2");
		u2.setPassword("testPass2");
		uRepo.save(u2);
		
		User u3 = new User();
		u3.setEmail("lameEmail@gmail.com");
		u3.setUsername("someoneElse");
		u3.setPassword("testPass3");
		uRepo.save(u3);
		
		assertEquals("esraman@iastate.edu", uServ.retrieveUserByEmail("esraman@iastate.edu").getEmail());
		assertEquals("ramanKid2", uServ.retrieveUserByEmail("caraman@iastate.edu").getUsername());
		assertEquals("testPass3", uServ.retrieveUserByEmail("lameEmail@gmail.com").getPassword()); 
	}
	
	@Test
	public void testGetUserByUsername() {
		List<User> uList = new ArrayList<>();
		
		when(uRepo.findAll()).thenReturn(uList);
		when(uRepo.save((User)any(User.class))).thenAnswer(x -> {
			User u = x.getArgument(0);
			uList.add(u);
			return null;
		});
		
		User u1 = new User();
		u1.setEmail("esraman@iastate.edu");
		u1.setUsername("ramanKid");
		u1.setPassword("testPass");
		uRepo.save(u1);
		
		User u2 = new User();
		u2.setEmail("caraman@iastate.edu");
		u2.setUsername("ramanKid2");
		u2.setPassword("testPass2");
		uRepo.save(u2);
		
		User u3 = new User();
		u3.setEmail("lameEmail@gmail.com");
		u3.setUsername("someoneElse");
		u3.setPassword("testPass3");
		uRepo.save(u3);
		
		assertEquals("esraman@iastate.edu", uServ.retrieveUserByUsername("ramanKid").getEmail());
		assertEquals("ramanKid2", uServ.retrieveUserByUsername("ramanKid2").getUsername());
		assertEquals("testPass3", uServ.retrieveUserByUsername("someoneElse").getPassword()); 
	}
	
	@Test
	public void testGetTrailByID() {
		List<Trail> tList = new ArrayList<>();
		
		when(tRepo.findAll()).thenReturn(tList);
		when(tRepo.save((Trail)any(Trail.class))).thenAnswer(x -> {
			Trail t = x.getArgument(0);
			tList.add(t);
			return null;
		});
		
		Trail t0 = new Trail();
		t0.setId(0);
		t0.setName("Trail 0 - Redrock");
		t0.setDifficulty(4);
		tRepo.save(t0);
		
		Trail t1 = new Trail();
		t1.setId(1);
		t1.setName("Trail 1 - Greenrock");
		t1.setDifficulty(5);
		tRepo.save(t1);
		
		Trail t2 = new Trail();
		t2.setId(2);
		t2.setName("Trail 2 - Bluerock");
		t2.setDifficulty(7);
		tRepo.save(t2);
		
		assertEquals(0, tServ.retrieveTrailByID(0).getId());
		assertEquals("Trail 0 - Redrock", tServ.retrieveTrailByID(0).getName());
		assertEquals(4, tServ.retrieveTrailByID(0).getDifficulty());
		
		assertEquals(1, tServ.retrieveTrailByID(1).getId());
		assertEquals("Trail 1 - Greenrock", tServ.retrieveTrailByID(1).getName());
		assertEquals(5, tServ.retrieveTrailByID(1).getDifficulty());
		
		assertEquals(2, tServ.retrieveTrailByID(2).getId());
		assertEquals("Trail 2 - Bluerock", tServ.retrieveTrailByID(2).getName());
		assertEquals(7, tServ.retrieveTrailByID(2).getDifficulty());
	}
	
	@Test
	public void testGetTrailByName() {
		List<Trail> tList = new ArrayList<>();
		
		when(tRepo.findAll()).thenReturn(tList);
		when(tRepo.save((Trail)any(Trail.class))).thenAnswer(x -> {
			Trail t = x.getArgument(0);
			tList.add(t);
			return null;
		});
		
		Trail t0 = new Trail();
		t0.setId(0);
		t0.setName("Trail 0 - Redrock");
		t0.setDifficulty(4);
		tRepo.save(t0);
		
		Trail t1 = new Trail();
		t1.setId(1);
		t1.setName("Trail 1 - Greenrock");
		t1.setDifficulty(5);
		tRepo.save(t1);
		
		Trail t2 = new Trail();
		t2.setId(2);
		t2.setName("Trail 2 - Bluerock");
		t2.setDifficulty(7);
		tRepo.save(t2);
		
		assertEquals(0, tServ.retrieveTrailByName("Trail 0 - Redrock").getId());
		assertEquals("Trail 0 - Redrock", tServ.retrieveTrailByName("Trail 0 - Redrock").getName());
		assertEquals(4, tServ.retrieveTrailByName("Trail 0 - Redrock").getDifficulty());
		
		assertEquals(1, tServ.retrieveTrailByName("Trail 1 - Greenrock").getId());
		assertEquals("Trail 1 - Greenrock", tServ.retrieveTrailByName("Trail 1 - Greenrock").getName());
		assertEquals(5, tServ.retrieveTrailByName("Trail 1 - Greenrock").getDifficulty());
		
		assertEquals(2, tServ.retrieveTrailByName("Trail 2 - Bluerock").getId());
		assertEquals("Trail 2 - Bluerock", tServ.retrieveTrailByName("Trail 2 - Bluerock").getName());
		assertEquals(7, tServ.retrieveTrailByName("Trail 2 - Bluerock").getDifficulty());
	}
	
	@Test
	public void testGetTrailListByDifficulty() {
		List<Trail> tList = new ArrayList<>();
		
		when(tRepo.findAll()).thenReturn(tList);
		when(tRepo.save((Trail)any(Trail.class))).thenAnswer(x -> {
			Trail t = x.getArgument(0);
			tList.add(t);
			return null;
		});
		
		Trail t0 = new Trail();
		t0.setId(0);
		t0.setName("Trail 0 - Redrock");
		t0.setDifficulty(4);
		tRepo.save(t0);
		
		Trail t1 = new Trail();
		t1.setId(1);
		t1.setName("Trail 1 - Greenrock");
		t1.setDifficulty(5);
		tRepo.save(t1);
		
		Trail t2 = new Trail();
		t2.setId(2);
		t2.setName("Trail 2 - Bluerock");
		t2.setDifficulty(7);
		tRepo.save(t2);
		
		assertEquals(1, tServ.retrieveTrailListByDifficulty(5).get(0).getId());
		assertEquals("Trail 1 - Greenrock", tServ.retrieveTrailListByDifficulty(5).get(0).getName());
		assertEquals(5, tServ.retrieveTrailListByDifficulty(5).get(0).getDifficulty());
	}
	
	@Test
	public void testSetNewPassword() {
		List<User> uList = new ArrayList<>();
		
		when(uRepo.findAll()).thenReturn(uList);
		when(uRepo.save((User)any(User.class))).thenAnswer(x -> {
			User u = x.getArgument(0);
			uList.add(u);
			return null;
		});
		
		User u1 = new User();
		u1.setEmail("esraman@iastate.edu");
		u1.setUsername("ramanKid");
		u1.setPassword("testPass");
		uRepo.save(u1);
		
		assertEquals(2, uServ.newPassword("wrongEmail@iastate.edu", "testPass", "newPass"));
		assertEquals(2, uServ.newPassword("wrongUsername", "testPass", "newPass"));
		assertEquals(1, uServ.newPassword("esraman@iastate.edu", "wrongPass", "newPass"));
		assertEquals(1, uServ.newPassword("ramanKid", "wrongPass", "newPass"));
		assertEquals(0, uServ.newPassword("esraman@iastate.edu", "testPass", "newPass"));
		assertEquals("newPass", uServ.retrieveUserByEmail("esraman@iastate.edu").getPassword()); 
	}
}
