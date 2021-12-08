package coms309.trailtraveler.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coms309.trailtraveler.backend.model.Trail;

/**
 * Implements a repository for Trails
 **/
public interface TrailRepository extends JpaRepository<Trail, Long> {

}