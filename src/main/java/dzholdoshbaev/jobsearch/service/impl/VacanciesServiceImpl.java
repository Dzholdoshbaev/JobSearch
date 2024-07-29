package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.VacanciesDao;
import dzholdoshbaev.jobsearch.dto.VacanciesDto;
import dzholdoshbaev.jobsearch.model.Vacancies;
import dzholdoshbaev.jobsearch.service.VacanciesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class VacanciesServiceImpl implements VacanciesService {
    private final VacanciesDao vacanciesDao;

    @Override
    public void createVacancies(Vacancies vacancies) {
        vacanciesDao.addVacancies(vacancies);
        log.info("Created vacancies: {}", vacancies.getName());
    }

    @Override
    public void editVacancy(Long vacancyId, VacanciesDto vacanciesDto) {
        System.out.println(vacancyId + " " + vacanciesDto);
    }

    @Override
    public void deleteVacancy(Long vacancyId) {
        System.out.println(vacancyId);
    }

    @Override
    public List<VacanciesDto> getAllVacancies() {
       var list = vacanciesDao.getAllVacancies();

        List<VacanciesDto> get = list.stream()
               .map(e -> VacanciesDto.builder()
                       .id(e.getId())
                       .name(e.getName())
                       .description(e.getDescription())
                       .categoryId(e.getCategoryId())
                       .salary(e.getSalary())
                       .expFrom(e.getExpFrom())
                       .expTo(e.getExpTo())
                       .isActive(e.isActive())
                       .authorId(e.getAuthorId())
                       .createdDate(e.getCreatedDate())
                       .updateTime(e.getUpdateTime())
                       .build()).toList();
        log.info("printed all vacancies");
        return get;
    }

    @Override
    public List<VacanciesDto> getAllVacanciesByCategory(int categoryId) {
        var list = vacanciesDao.getAllVacanciesByCategory(categoryId);

        List<VacanciesDto> sorted = list.stream()
                .map(e -> VacanciesDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .description(e.getDescription())
                        .categoryId(e.getCategoryId())
                        .salary(e.getSalary())
                        .expFrom(e.getExpFrom())
                        .expTo(e.getExpTo())
                        .isActive(e.isActive())
                        .authorId(e.getAuthorId())
                        .createdDate(e.getCreatedDate())
                        .updateTime(e.getUpdateTime())
                        .build()).toList();
        log.info("printed all vacancies by category");
        return sorted;
    }
}