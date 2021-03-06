package coms309.trailtraveler.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import coms309.trailtraveler.backend.model.Trail;
import coms309.trailtraveler.backend.service.TrailService;

/** The TrailController class handles http requests from the frontend of the application and depends on the TrailService class. **/
@RestController
public class TrailController {
	
	/** Instance variable that instantiates a TrailService object. **/
	@Autowired
	TrailService ts;

	/** Returns a list of every trail in the trail repository.
	 * 	@return
	 * 	 The list of all trails within the trail repository.  **/
	@GetMapping("trail/all")
	List<Trail> getAllTrails() {
		return ts.retrieveAllTrails();
	}
	
	/** Adds a trail object with the given parameters to the trail repository.
	 * @param name
	 *  The name of the trail to be added to the repository.
	 * @param difficulty
	 *  The difficulty of the trail to be added to the repository.
	 * @return
	 * 	If successful, returns the trail object created and and added to the repository.
	 *  **/
	@PostMapping("trail/post/{name}/{difficulty}/{distance}")
	Trail postTrailByPath(@PathVariable String name, @PathVariable int difficulty, @PathVariable int distance) {
		return ts.postTrail(name, difficulty, distance);
	}
	
	@GetMapping("trail/id/{id}")
	Trail getTrailByID(@PathVariable int id) {
		return ts.retrieveTrailByID(id);
	}
	
	@GetMapping("trail/name/{name}")
	Trail getTrailByName(@PathVariable String name) {
		return ts.retrieveTrailByName(name);
	}
	
	@GetMapping("trail/difficulty/{difficulty}")
	List<Trail> getTrailListByDifficulty(@PathVariable int dif) {
		return ts.retrieveTrailListByDifficulty(dif);
	}
	
	@GetMapping("trail/averageRating/{trailName}")
	double getAverageTrailRating(@PathVariable String trailName) {
		return ts.retrieveTrailRating(trailName);
	}
}
