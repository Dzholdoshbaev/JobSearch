package dzholdoshbaev.jobsearch.repository;

import dzholdoshbaev.jobsearch.model.Vacancies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacanciesRepository extends JpaRepository<Vacancies, Long> {
    @Query("select v from Vacancies v where v.users.id = :applicantId")
    List<Vacancies> findAllByApplicantId(Long applicantId);


}
