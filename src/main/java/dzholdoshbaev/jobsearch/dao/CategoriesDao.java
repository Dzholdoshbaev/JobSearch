package dzholdoshbaev.jobsearch.dao;

import jdk.jfr.Category;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@Data
public class CategoriesDao {
    private List<Category> categoriesList = new ArrayList<>();
}
