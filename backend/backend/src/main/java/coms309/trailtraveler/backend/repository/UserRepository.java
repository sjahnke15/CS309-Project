package coms309.trailtraveler.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coms309.trailtraveler.backend.model.User;

/*
 * Implements a repository for Users
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
