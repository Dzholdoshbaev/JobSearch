package dzholdoshbaev.jobsearch.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriesDto {
    private int id;
    private String name;
    private int parentIdCategories;
}
