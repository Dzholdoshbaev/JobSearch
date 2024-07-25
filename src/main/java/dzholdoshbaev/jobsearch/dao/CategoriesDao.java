package dzholdoshbaev.jobsearch.dao;

import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class CategoriesDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Category> getAllCategories() {
        String sql = "select * from categories";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
    }

}
