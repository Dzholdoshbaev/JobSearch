package dzholdoshbaev.jobsearch.model;

import lombok.Data;

@Data
public class Categories {
    private int id;
    private String name;
    private int parentIdCategories;
}
