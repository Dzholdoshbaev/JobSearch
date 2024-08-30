package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.model.Vacancies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface VacanciesService {
    void createVacancies(Vacancies vacanciesDto);

    void editVacancy(Vacancies vacanciesDto,Long vacancyId);

    void deleteVacancy(Long vacancyId);

    Page<Vacancies> getAllVacancies(Pageable pageable);

    List<Vacancies> getAllVacanciesByCategory(Long categoryId);

    Vacancies getVacanciesById(Long vacanciesId);

    List<Vacancies> getAllVacanciesByUser(Long id);

    void updateVacancy(Long vacancyId);
}
