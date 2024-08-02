package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.Vacancies;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VacanciesDao {
    private final JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void addVacancies(Vacancies vacancies) {
        String sql = "insert into vacancies (name, description, category_id, salary, exp_from, exp_to, is_active,author_id,created_date,update_time) values (name, :description, :categoryId, :salary, :expFrom, :expTo, :isActive, :authorId, :createdDate, :updateTime)";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource()
                .addValue("name", vacancies.getName())
                .addValue("description", vacancies.getDescription())
                .addValue("category_id", vacancies.getCategoryId())
                .addValue("salary", vacancies.getSalary())
                .addValue("exp_from", vacancies.getExpFrom())
                .addValue("exp_to", vacancies.getExpTo())
                .addValue("is_active", vacancies.isActive())
                .addValue("author_id", vacancies.getAuthorId())
                .addValue("created_date", vacancies.getCreatedDate())
                .addValue("update_time", vacancies.getUpdateTime()));
    }

    public void editVacancies(Vacancies vacancies) {
        String sql = """
            UPDATE vacancies
            SET name = :name,
                description = :description,
                CATEGORY_ID = :categoryId,
                SALARY = :salary,
                EXP_FROM = :expFrom,
                EXP_TO = :expTo,
                is_active = :isActive,
                update_time = :updateTime
            WHERE ID = :id;
            """;

        Map<String, Object> params = new HashMap<>();
        params.put("name", vacancies.getName());
        params.put("description", vacancies.getDescription());
        params.put("categoryId", vacancies.getCategoryId());
        params.put("salary", vacancies.getSalary());
        params.put("expFrom", vacancies.getExpFrom());
        params.put("expTo", vacancies.getExpTo());
        params.put("is_active", vacancies.isActive());
        params.put("update_time", vacancies.getUpdateTime());
        params.put("id", vacancies.getId());

        namedParameterJdbcTemplate.update(sql, params);
    }

    public void deleteVacancies(Long vacancyId) {
        String sql = "delete from vacancies where id = :vacancyId";

        Map<String, Object> params = new HashMap<>();
        params.put("vacancyId", vacancyId);

        namedParameterJdbcTemplate.update(sql, params);
    }


    public List<Vacancies> getAllVacancies() {
        String sql = "SELECT * FROM vacancies";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Vacancies.class));
    }

    public List<Vacancies> getAllVacanciesByCategory(int categoryId) {
        String sql = "SELECT * FROM vacancies where category_id = ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Vacancies.class),categoryId);
    }

    public Optional<Vacancies> getVacanciesById(int id) {
        String sql = "select * from vacancies where id = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Vacancies.class),id)
                )
        );
    }

}
