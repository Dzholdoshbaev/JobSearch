package dzholdoshbaev.jobsearch.service.impl;


import dzholdoshbaev.jobsearch.model.Vacancies;
import dzholdoshbaev.jobsearch.repository.VacanciesRepository;
import dzholdoshbaev.jobsearch.service.VacanciesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class VacanciesServiceImpl implements VacanciesService {
    private final VacanciesRepository vacanciesRepository;

    @Override
    public void createVacancies(Vacancies vacanciesDto , Long userId) {

        log.info("Created vacancies");
    }

    @Override
    public void editVacancy( Vacancies vacancies) {
        log.info("Edited vacancies: {}", vacancies.getName());
    }

    @Override
    public void deleteVacancy(Long vacancyId) {
        vacanciesRepository.deleteById(vacancyId);
        log.info("Deleted vacancies: {}", vacancyId);
    }

    @Override
    public List<Vacancies> getAllVacancies() {
        log.info("printed all vacancies");
        return vacanciesRepository.findAll();
    }

    @Override
    public List<Vacancies> getAllVacanciesByCategory(Long categoryId) {
        return List.of();
    }

    @Override
    public Vacancies getVacanciesById(Long vacanciesId) {
        Optional<Vacancies> vacancies = vacanciesRepository.findById(vacanciesId);
        log.info("printed vacancies: {}", vacanciesId);
        return vacancies.orElse(null);
    }

    @Override
    public List<Vacancies> getAllVacanciesByUser(Long id) {
        var list = vacanciesRepository.findAllByApplicantId(id);
        log.info("printed all vacancies by user");
        return list;
    }
}