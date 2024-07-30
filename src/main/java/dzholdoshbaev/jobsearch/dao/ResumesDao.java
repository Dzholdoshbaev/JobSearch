package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.Resumes;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ResumesDao {
    private final JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void addResume(Resumes resumes) {
        String sql = "insert into resumes (applicant_id,name,category_id,salary,is_active,created_date,update_time) values ( :applicantId, :name, :categoryId, :salary, :isActive, :createdDate, :updateTime)";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource()
                .addValue("applicantId", resumes.getApplicantId())
                .addValue("name", resumes.getName())
                .addValue("categoryId", resumes.getCategoryId())
                .addValue("salary", resumes.getSalary())
                .addValue("isActive",resumes.isActive())
                .addValue("createdDate", resumes.getCreatedDate())
                .addValue("updateTime",resumes.getUpdateTime()));
    }

    public void editResume(Resumes resumes) {
        String sql = """
            UPDATE resumes
            SET name = :name,
                category_id = :categoryId,
                salary = :salary,
                is_active = :isActive,
                update_time = :updateTime
            WHERE applicant_id = :applicantId
            """;

        Map<String, Object> params = new HashMap<>();
        params.put("name", resumes.getName());
        params.put("categoryId", resumes.getCategoryId());
        params.put("salary", resumes.getSalary());
        params.put("isActive", resumes.isActive());
        params.put("updateTime", resumes.getUpdateTime());
        params.put("applicantId", resumes.getApplicantId());

        namedParameterJdbcTemplate.update(sql, params);
    }


    public List<Resumes> getAllResumes() {
        String sql = "select * from resumes";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Resumes.class));
    }

    public List<Resumes> getAllResumesByCategory(int categoryId) {
        String sql = "SELECT * FROM resumes where category_id = ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Resumes.class),categoryId);
    }

    public List<Resumes> getAllResumesByUser(int applicantId) {
        String sql = "SELECT * FROM resumes where applicant_id = ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Resumes.class),applicantId);
    }

    public Optional<Resumes> getResumeById(int id) {
        String sql = "select * from resumes where id = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Resumes.class),id)
                )
        );
    }
}
