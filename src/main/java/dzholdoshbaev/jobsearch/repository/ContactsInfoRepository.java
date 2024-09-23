package dzholdoshbaev.jobsearch.repository;

import dzholdoshbaev.jobsearch.model.ContactTypes;
import dzholdoshbaev.jobsearch.model.ContactsInfo;
import dzholdoshbaev.jobsearch.model.Resumes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsInfoRepository extends JpaRepository<ContactsInfo, Long> {
     List<ContactsInfo> findByResumes_Id(Long resumesId);


     @Transactional
     @Modifying
     @Query("""
            UPDATE ContactsInfo c
            SET c.contactTypes = :contactTypes,
            c.info = :info
            WHERE c.resumes = :resumes
            """)
     void updateEducationInfoByResumes_Id(@Param("contactTypes") ContactTypes contactTypes,
                                          @Param("info") String info,
                                          @Param("resumes") Resumes resumes);

     @Transactional
     @Modifying
     @Query("DELETE FROM ContactsInfo c WHERE c.resumes = :resumes")
     void deleteByResumes(Resumes resumes);


}
