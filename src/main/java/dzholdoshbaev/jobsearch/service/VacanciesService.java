package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.model.Vacancies;

import java.util.List;
import java.util.Optional;

public interface VacanciesService {
    void createVacancies(Vacancies vacanciesDto , Long userId);

    void editVacancy(Vacancies vacanciesDto);

    void deleteVacancy(Long vacancyId);

    List<Vacancies> getAllVacancies();

    List<Vacancies> getAllVacanciesByCategory(Long categoryId);

    Optional<Vacancies> getVacanciesById(Long vacanciesId);

    List<Vacancies> getAllVacanciesByUser(Long id);
}
