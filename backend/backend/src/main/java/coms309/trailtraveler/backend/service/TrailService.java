package coms309.trailtraveler.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import coms309.trailtraveler.backend.model.Trail;
import coms309.trailtraveler.backend.repository.TrailRepository;

public class TrailService {

	@Autowired
	TrailRepository tRepo;
	
	public List<Trail> retrieveAllTrails() {
		return tRepo.findAll();
	}

	public Trail postTrail(String n, int d) {
		Trail trail = new Trail();
		trail.setName(n);
		trail.setDifficulty(d);
		tRepo.save(trail);
		return trail;
	}

}