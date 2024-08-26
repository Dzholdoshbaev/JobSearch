package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.model.Vacancies;

import java.util.List;
import java.util.Optional;

public interface VacanciesService {
    void createVacancies(Vacancies vacanciesDto);

    void editVacancy(Vacancies vacanciesDto,Long vacancyId);

    void deleteVacancy(Long vacancyId);

    List<Vacancies> getAllVacancies();

    List<Vacancies> getAllVacanciesByCategory(Long categoryId);

    Vacancies getVacanciesById(Long vacanciesId);

    List<Vacancies> getAllVacanciesByUser(Long id);
}
