package dzholdoshbaev.jobsearch.service.impl;


import dzholdoshbaev.jobsearch.model.Categories;
import dzholdoshbaev.jobsearch.model.Vacancies;
import dzholdoshbaev.jobsearch.repository.CategoriesRepository;
import dzholdoshbaev.jobsearch.repository.RespondedApplicantsRepository;
import dzholdoshbaev.jobsearch.repository.VacanciesRepository;
import dzholdoshbaev.jobsearch.service.VacanciesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class VacanciesServiceImpl implements VacanciesService {
    private final VacanciesRepository vacanciesRepository;
    private final CategoriesRepository categoriesRepository;
    private final RespondedApplicantsRepository respondedApplicantsRepository;

    public void createVacancies(Vacancies vacanciesDto) {
        Categories category = categoriesRepository.findById(vacanciesDto.getCategories().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));
        vacanciesDto.setCategories(category);

        vacanciesDto.setCreatedDate(LocalDateTime.now());
        vacanciesDto.setUpdateTime(LocalDateTime.now());
        vacanciesRepository.save(vacanciesDto);
        log.info("Created vacancies");
    }

    @Override
    public void editVacancy( Vacancies vacancies,Long vacancyId) {

        vacanciesRepository.updateVacanciesById(vacancies.getName(),
                vacancies.getDescription(),
                vacancies.getSalary(),
                vacancies.getExpFrom(),
                vacancies.getExpTo(),
                vacancies.getIsActive(),
                vacancyId);
        log.info("Edited vacancies: {}", vacancies.getName());
    }

    @Override
    public void deleteVacancy(Long vacancyId) {
        vacanciesRepository.deleteById(vacancyId);
        log.info("Deleted vacancies: {}", vacancyId);
    }

    @Override
    public Page<Vacancies> getAllVacancies(Pageable pageable) {
        if (pageable.getSort().toString().contains("respondAmount")) {
            Map<Long, Long> vacancyResponseCountMap = respondedApplicantsRepository.findAll().stream()
                    .collect(Collectors.groupingBy(
                            applicant -> applicant.getVacancies().getId(),
                            Collectors.counting()
                    ));

            vacancyResponseCountMap.forEach(vacanciesRepository::updateVacanciesRespondAmount);

            Sort sortBy = Sort.by(Sort.Order.desc("respondAmount"));
            Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sortBy);

            return vacanciesRepository.findAll(sortedPageable);
        } else {
            return vacanciesRepository.findAll(pageable);
        }
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

    @Override
    public void updateVacancy(Long vacancyId) {
        vacanciesRepository.updateVacanciesUpdateTime(vacancyId, LocalDateTime.now());
        log.info("Updated vacancies: {}", vacancyId);
    }

}