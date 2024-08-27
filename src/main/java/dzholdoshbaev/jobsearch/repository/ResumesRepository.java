package dzholdoshbaev.jobsearch.repository;

import dzholdoshbaev.jobsearch.model.Resumes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ResumesRepository extends JpaRepository<Resumes, Long> {

    @Query("select r from Resumes r where r.users.id = :applicantId")
    List<Resumes> findAllByApplicantId(Long applicantId);


    @Transactional
    @Modifying
    @Query("""
        UPDATE Resumes r
        SET r.updateTime = :updateTime
        WHERE r.id = :id
        """)
    void updateResumesUpdateTime(@Param("id") Long resumeId, @Param("updateTime") LocalDateTime updateTime);




}
