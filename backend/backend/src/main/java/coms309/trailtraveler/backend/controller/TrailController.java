package coms309.trailtraveler.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import coms309.trailtraveler.backend.model.Trail;
import coms309.trailtraveler.backend.repository.TrailRepository;

@RestController
public class TrailController {

	@Autowired
	TrailRepository trailRepository;
	
	@GetMapping("trail/all")
	List<Trail> getAllTrails() {
		return trailRepository.findAll();
	}
	
	@PostMapping("trail/post/{n}/{d}")
	Trail postTrailByPath(@PathVariable String n, @PathVariable int d) {
		Trail t = new Trail();
		t.setName(n);
		t.setDifficulty(d);
		trailRepository.save(t);
		return t;
	}
}
