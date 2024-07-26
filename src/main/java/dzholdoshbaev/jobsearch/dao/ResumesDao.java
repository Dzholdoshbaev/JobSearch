package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.Resumes;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
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
}
