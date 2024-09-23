package dzholdoshbaev.jobsearch.repository;

import dzholdoshbaev.jobsearch.model.Resumes;
import dzholdoshbaev.jobsearch.model.WorkExperienceInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WorkExperienceInfoRepository extends JpaRepository<WorkExperienceInfo, Long> {
    List<WorkExperienceInfo> findByResumes_Id(Long resumeId);


    @Transactional
    @Modifying
    @Query("""
            UPDATE WorkExperienceInfo w
            SET w.companyName = :companyName,
            w.position = :position,
            w.years = :years,
            w.responsibilities = :responsibilities
            WHERE w.resumes = :resumes
            """)
    void updateWorkExperienceInfoByResumeId(@Param("companyName") String companyName,
                                         @Param("position") String position,
                                         @Param("years") Long years,
                                         @Param("responsibilities") String responsibilities,
                                         @Param("resumes") Resumes resumes);

}
