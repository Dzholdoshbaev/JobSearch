package dzholdoshbaev.jobsearch.repository;

import dzholdoshbaev.jobsearch.model.Vacancies;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacanciesRepository extends JpaRepository<Vacancies, Long> {
    @Query("select v from Vacancies v where v.users.id = :applicantId")
    List<Vacancies> findAllByApplicantId(Long applicantId);

    @Transactional
    @Modifying
    @Query("""
            UPDATE Vacancies v
            SET v.name = :name,
            v.description = :description,
            v.salary = :salary,
            v.expFrom = :expFrom,
            v.expTo = :expTo,
            v.isActive = :isActive
            WHERE v.id = :id
            """)
    void updateVacanciesById(@Param("name") String name,
                             @Param("description") String description,
                             @Param("salary") Double salary,
                             @Param("expFrom") Long expFrom,
                             @Param("expTo") Long expTo,
                             @Param("isActive") Boolean isActive,
                             @Param("id") Long id);

}
