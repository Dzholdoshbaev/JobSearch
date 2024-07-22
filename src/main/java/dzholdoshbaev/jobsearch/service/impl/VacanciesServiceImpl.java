package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dto.VacanciesDto;
import dzholdoshbaev.jobsearch.service.VacanciesService;
import org.springframework.stereotype.Service;

@Service
public class VacanciesServiceImpl implements VacanciesService {
    @Override
    public void createVacancies(VacanciesDto vacanciesDto) {
        System.out.println(vacanciesDto);
    }

    @Override
    public void editVacancy(Long vacancyId, VacanciesDto vacanciesDto) {
        System.out.println(vacancyId + " " + vacanciesDto);
    }

    @Override
    public void deleteVacancy(Long vacancyId) {
        System.out.println(vacancyId);
    }
}
