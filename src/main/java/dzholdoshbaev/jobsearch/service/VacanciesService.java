package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.dto.VacanciesDto;

public interface VacanciesService {
    void createVacancies(VacanciesDto vacanciesDto);

    void editVacancy(Long vacancyId, VacanciesDto vacanciesDto);

    void deleteVacancy(Long vacancyId);
}
