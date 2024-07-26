package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.dto.VacanciesDto;
import dzholdoshbaev.jobsearch.model.Vacancies;

import java.util.List;

public interface VacanciesService {
    void createVacancies(Vacancies vacancies);

    void editVacancy(Long vacancyId, VacanciesDto vacanciesDto);

    void deleteVacancy(Long vacancyId);

    List<VacanciesDto> getAllVacancies();

    List<VacanciesDto> getAllVacanciesByCategory(int categoryId);
}
