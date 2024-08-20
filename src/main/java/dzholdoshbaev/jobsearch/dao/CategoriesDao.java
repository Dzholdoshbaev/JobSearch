package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.Categories;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CategoriesDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Categories> getAllCategories() {
        String sql = "select * from categories";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Categories.class));
    }


}
