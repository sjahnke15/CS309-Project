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
	
	/*
	 * Retrieves a list of all trails from the trail repository
	 * @return
	 * A list of trials
	 */
	public List<Trail> retrieveAllTrails() {
		return tRepo.findAll();
	}

	/*
	 * Posts a trail with the given trail information to the trail repository
	 * @param
	 * A trail name
	 * @param
	 * A trail difficulty
	 * @return
	 * The new trail
	 */
	public Trail postTrail(String n, int d) {
		Trail trail = new Trail();
		trail.setName(n);
		trail.setDifficulty(d);
		tRepo.save(trail);
		return trail;
	}

	/*
	 * Retrieves a trail with a trail ID matching the input
	 * @param
	 * A trail ID
	 * @return
	 * A trail
	 */
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
	
	/*
	 * Retrieves a trail with a trail name matching the input
	 * @param
	 * A trail name
	 * @return
	 * A trail
	 */
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
	
	/*
	 * Retrieves a list of trails with a trail difficulty matching the input
	 * @param
	 * A difficulty
	 * @return
	 * A list of trails
	 */
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