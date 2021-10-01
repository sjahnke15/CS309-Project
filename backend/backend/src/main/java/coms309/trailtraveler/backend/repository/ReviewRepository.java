package coms309.trailtraveler.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coms309.trailtraveler.backend.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
