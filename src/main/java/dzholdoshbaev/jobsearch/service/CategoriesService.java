package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.dto.CategoriesDto;

import java.util.List;

public interface CategoriesService {
    List<CategoriesDto> getCategories();
}
