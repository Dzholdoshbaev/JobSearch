package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.CategoriesDao;
import dzholdoshbaev.jobsearch.dto.CategoriesDto;
import dzholdoshbaev.jobsearch.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class CategoriesServiceImpl implements CategoriesService {
    private final CategoriesDao categoriesDao;

    @Override
    public List<CategoriesDto> getCategories() {
        return new ArrayList<>();
    }
}
