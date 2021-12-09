package coms309.trailtraveler.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coms309.trailtraveler.backend.model.Message;

/**
 * Implements a repository for Messages
 **/
public interface MessageRepository extends JpaRepository<Message, Long> {

}