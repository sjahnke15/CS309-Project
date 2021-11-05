package coms309.trailtraveler.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms309.trailtraveler.backend.model.Trail;
import coms309.trailtraveler.backend.repository.TrailRepository;

@Service
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

	public Trail retrieveTrailByID(int id) {
		List<Trail> trailList = tRepo.findAll();
		Trail trail;
		for (int i = 0; i < trailList.size(); i++) {
			if (trailList.get(i).getId() == id) {
				trail = trailList.get(i);
				return trail;
			}
		}
		return null;
	}
	
	public Trail retrieveTrailByName(String name) {
		List<Trail> trailList = tRepo.findAll();
		Trail trail;
		for (int i = 0; i < trailList.size(); i++) {
			if (trailList.get(i).getName().equals(name)) {
				trail = trailList.get(i);
				return trail;
			}
		}
		return null;
	}
	
	public List<Trail> retrieveTrailListByDifficulty(int dif) {
		List<Trail> trailList = tRepo.findAll();
		for (int i = 0; i < trailList.size(); i++) {
			if (trailList.get(i).getDifficulty() != dif) {
				trailList.remove(i);
			}
		}
		return trailList;
	}
}