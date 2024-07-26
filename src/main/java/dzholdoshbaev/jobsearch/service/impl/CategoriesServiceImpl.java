package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.CategoriesDao;
import dzholdoshbaev.jobsearch.dto.CategoriesDto;
import dzholdoshbaev.jobsearch.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriesServiceImpl implements CategoriesService {
    private final CategoriesDao categoriesDao;

    @Override
    public List<CategoriesDto> getCategories() {
    var list = categoriesDao.getAllCategories();

        return list.stream()
                .map(c -> CategoriesDto.builder()
                        .id(c.getId())
                      .name(c.getName())
                       .parentIdCategories(c.getParentIdCategories())
                      .build())
              .toList();
    }
}
