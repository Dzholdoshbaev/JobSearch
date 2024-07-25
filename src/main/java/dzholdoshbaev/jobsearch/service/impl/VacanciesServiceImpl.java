package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.VacanciesDao;
import dzholdoshbaev.jobsearch.dto.VacanciesDto;
import dzholdoshbaev.jobsearch.service.VacanciesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class VacanciesServiceImpl implements VacanciesService {
    private final VacanciesDao vacanciesDao;

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
