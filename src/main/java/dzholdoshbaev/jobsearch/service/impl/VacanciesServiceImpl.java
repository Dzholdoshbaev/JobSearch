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
    public void createVacancies(VacanciesDto vacanciesDto) {

        Vacancies vacancies = Vacancies.builder()
                .id(vacanciesDto.getId())
                .name(vacanciesDto.getName())
                .description(vacanciesDto.getDescription())
                .categoryId(vacanciesDto.getCategoryId())
                .salary(vacanciesDto.getSalary())
                .expFrom(vacanciesDto.getExpFrom())
                .expTo(vacanciesDto.getExpTo())
                .isActive(vacanciesDto.isActive())
                .authorId(vacanciesDto.getAuthorId())
                .createdDate(vacanciesDto.getCreatedDate())
                .updateTime(vacanciesDto.getUpdateTime())
                .build();

        vacanciesDao.addVacancies(vacancies);
        log.info("Created vacancies: {}", vacancies.getName());
    }

    @Override
    public void editVacancy( VacanciesDto vacanciesDto) {

        Vacancies vacancies = Vacancies.builder()
                .id(vacanciesDto.getId())
                .name(vacanciesDto.getName())
                .description(vacanciesDto.getDescription())
                .categoryId(vacanciesDto.getCategoryId())
                .salary(vacanciesDto.getSalary())
                .expFrom(vacanciesDto.getExpFrom())
                .expTo(vacanciesDto.getExpTo())
                .isActive(vacanciesDto.isActive())
                .authorId(vacanciesDto.getAuthorId())
                .createdDate(vacanciesDto.getCreatedDate())
                .updateTime(vacanciesDto.getUpdateTime())
                .build();

        vacanciesDao.editVacancies(vacancies);
        log.info("Edited vacancies: {}", vacancies.getName());
    }

    @Override
    public void deleteVacancy(Long vacancyId) {
        vacanciesDao.deleteVacancies(vacancyId);
        log.info("Deleted vacancies: {}", vacancyId);
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

    @Override
    public VacanciesDto getVacanciesById(int vacanciesId) {
        var object = vacanciesDao.getVacanciesById(vacanciesId)
                .orElseThrow(() -> new RuntimeException("vacancies not found"));

        VacanciesDto corrected = VacanciesDto.builder()
                .id(object.getId())
                .name(object.getName())
                .description(object.getDescription())
                .categoryId(object.getCategoryId())
                .salary(object.getSalary())
                .expFrom(object.getExpFrom())
                .expTo(object.getExpTo())
                .isActive(object.isActive())
                .authorId(object.getAuthorId())
                .createdDate(object.getCreatedDate())
                .updateTime(object.getUpdateTime())
                .build();
        log.info("printed corrected vacancies by id {}", corrected.getId());
        return corrected;
    }

    @Override
    public List<VacanciesDto> getAllVacanciesByUser(int id) {
        var list = vacanciesDao.getAllVacanciesByUser(id);

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
        log.info("printed all vacancies by user");
        return sorted;
    }
}