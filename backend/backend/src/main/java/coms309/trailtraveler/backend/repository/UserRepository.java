package coms309.trailtraveler.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coms309.trailtraveler.backend.model.Trail;

public interface UserRepository extends JpaRepository<Trail, Long> {

}