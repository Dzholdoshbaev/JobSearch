package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.CategoriesDao;
import dzholdoshbaev.jobsearch.dto.CategoriesDto;
import dzholdoshbaev.jobsearch.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class CategoriesServiceImpl implements CategoriesService {
    private final CategoriesDao categoriesDao;

    @Override
    public List<CategoriesDto> getCategories() {
    var list = categoriesDao.getAllCategories();

        List<CategoriesDto> sorted =  list.stream()
                .map(c -> CategoriesDto.builder()
                        .id(c.getId())
                      .name(c.getName())
                       .parentIdCategories(c.getParentIdCategories())
                      .build())
              .toList();
        log.info("printed all categories");
        return sorted;
    }
}
