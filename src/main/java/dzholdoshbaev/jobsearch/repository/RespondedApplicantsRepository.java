package dzholdoshbaev.jobsearch.repository;

import dzholdoshbaev.jobsearch.model.RespondedApplicants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespondedApplicantsRepository extends JpaRepository<RespondedApplicants, Long> {
}
