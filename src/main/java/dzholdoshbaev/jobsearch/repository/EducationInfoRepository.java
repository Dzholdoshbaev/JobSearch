package dzholdoshbaev.jobsearch.repository;

import dzholdoshbaev.jobsearch.model.EducationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationInfoRepository extends JpaRepository<EducationInfo, Long> {
     EducationInfo findByResumes_Id(Long resumesId);
}
