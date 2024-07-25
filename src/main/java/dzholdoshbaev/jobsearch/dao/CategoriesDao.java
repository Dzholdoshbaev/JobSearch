package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.Users;
import jdk.jfr.Category;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Component
@RequiredArgsConstructor
public class CategoriesDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Category> getAllCategories() {
        String sql = "select * from categories";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Category.class));
    }

}
