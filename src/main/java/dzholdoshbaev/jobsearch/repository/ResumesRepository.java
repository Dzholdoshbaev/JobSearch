package dzholdoshbaev.jobsearch.repository;

import dzholdoshbaev.jobsearch.model.Resumes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumesRepository extends JpaRepository<Resumes, Long> {

    @Query("select r from Resumes r where r.users.id = :applicantId")
    List<Resumes> findAllByApplicantId(Long applicantId);





}
