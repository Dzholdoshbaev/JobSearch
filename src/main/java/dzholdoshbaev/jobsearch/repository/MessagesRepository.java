package dzholdoshbaev.jobsearch.repository;

import dzholdoshbaev.jobsearch.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long> {
}
