package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.Vacancies;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class VacanciesDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Vacancies> getAllVacancies() {
        String sql = "SELECT * FROM vacancies";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Vacancies.class));
    }

    public List<Vacancies> getAllVacanciesByCategory(int categoryId) {
        String sql = "SELECT * FROM vacancies where category_id = ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Vacancies.class),categoryId);
    }


}
