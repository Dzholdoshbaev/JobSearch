package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dto.CategoriesDto;
import dzholdoshbaev.jobsearch.service.CategoriesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Override
    public List<CategoriesDto> getCategories() {
        return new ArrayList<>();
    }
}
