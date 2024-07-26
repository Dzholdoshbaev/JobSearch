package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.VacanciesDao;
import dzholdoshbaev.jobsearch.dto.VacanciesDto;
import dzholdoshbaev.jobsearch.service.VacanciesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<VacanciesDto> getAllVacancies() {
       var list = vacanciesDao.getAllVacancies();

       return list.stream()
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
    }

    @Override
    public List<VacanciesDto> getAllVacanciesByCategory(int categoryId) {
        var list = vacanciesDao.getAllVacanciesByCategory(categoryId);

        return list.stream()
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
    }
}