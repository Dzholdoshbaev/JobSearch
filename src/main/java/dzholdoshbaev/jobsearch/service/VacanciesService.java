package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.dto.VacanciesDto;

import java.util.List;

public interface VacanciesService {
    void createVacancies(VacanciesDto vacanciesDto);

    void editVacancy(Long vacancyId, VacanciesDto vacanciesDto);

    void deleteVacancy(Long vacancyId);

    List<VacanciesDto> getAllVacancies();

    List<VacanciesDto> getAllVacanciesByCategory(int categoryId);
}
