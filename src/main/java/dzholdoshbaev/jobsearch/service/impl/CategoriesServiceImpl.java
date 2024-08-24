package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.model.Categories;
import dzholdoshbaev.jobsearch.repository.CategoriesRepository;
import dzholdoshbaev.jobsearch.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoriesServiceImpl implements CategoriesService {
    private final CategoriesRepository categoriesRepository;

    @Override
    public List<Categories> getCategories() {
        log.info("printed all categories");
        return categoriesRepository.findAll();
    }
}
