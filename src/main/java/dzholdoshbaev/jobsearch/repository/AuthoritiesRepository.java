package dzholdoshbaev.jobsearch.repository;

import dzholdoshbaev.jobsearch.model.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {
}
