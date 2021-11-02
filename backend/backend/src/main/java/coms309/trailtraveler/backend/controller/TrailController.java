package coms309.trailtraveler.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import coms309.trailtraveler.backend.model.Trail;
import coms309.trailtraveler.backend.repository.TrailRepository;
import coms309.trailtraveler.backend.service.TrailService;

@RestController
public class TrailController {

	@Autowired
	TrailRepository trailRepository;
	
	@Autowired
	TrailService ts;
	
	@GetMapping("trail/all")
	List<Trail> getAllTrails() {
		return ts.retrieveAllTrails();
	}
	
	@PostMapping("trail/post/{name}/{difficulty}")
	Trail postTrailByPath(@PathVariable String name, @PathVariable int difficulty) {
		return ts.postTrail(name, difficulty);
	}
}
