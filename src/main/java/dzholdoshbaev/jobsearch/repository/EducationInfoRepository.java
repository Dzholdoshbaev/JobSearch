package dzholdoshbaev.jobsearch.repository;

import dzholdoshbaev.jobsearch.model.EducationInfo;
import dzholdoshbaev.jobsearch.model.Resumes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EducationInfoRepository extends JpaRepository<EducationInfo, Long> {
     EducationInfo findByResumes_Id(Long resumesId);


     @Transactional
     @Modifying
     @Query("""
            UPDATE EducationInfo e
            SET e.institution = :institution,
            e.program = :program,
            e.startDate = :startDate,
            e.endDate = :endDate,
            e.degree = :degree
            WHERE e.resumes = :resumes
            """)
     void updateEducationInfoByResumes_Id(@Param("institution") String institution,
                            @Param("program") String program,
                            @Param("startDate") LocalDate startDate,
                            @Param("endDate") LocalDate endDate,
                            @Param("degree") String degree,
                            @Param("resumes") Resumes resumes);
}
