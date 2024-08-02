package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.EducationInfo;
import dzholdoshbaev.jobsearch.model.Resumes;
import dzholdoshbaev.jobsearch.model.WorkExperienceInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.PreparedStatement;
import java.util.*;

@Component
@RequiredArgsConstructor
public class ResumesDao {
    private final JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final KeyHolder keyHolder = new GeneratedKeyHolder();

    public void addResume( Resumes resume,EducationInfo educationInfo, WorkExperienceInfo workExperienceInfo) {
        String resumeSql = "INSERT INTO resumes (applicant_id, name, category_id, salary, is_active, created_date, update_time) VALUES (?,?,?,?,?,?,?)";

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(resumeSql,new String[]{"id"});
            ps.setInt(1, resume.getApplicantId());
            ps.setString(2, resume.getName());
            ps.setInt(3, resume.getCategoryId());
            ps.setDouble(4, resume.getSalary());
            ps.setBoolean(5, resume.isActive());
            ps.setObject(6, resume.getCreatedDate());
            ps.setObject(7, resume.getUpdateTime());
            return ps;
        },keyHolder);

         int resumeId = Objects.requireNonNull(keyHolder.getKey()).intValue();

        String educationSql = "INSERT INTO education_info (resume_id, degree, institution, PROGRAM,START_DATE,END_DATE) VALUES (:resumeId, :degree, :institution, :PROGRAM , :startDate, :endDate)";
        namedParameterJdbcTemplate.update(educationSql, new MapSqlParameterSource()
                .addValue("resumeId", resumeId)
                .addValue("degree", educationInfo.getDegree())
                .addValue("institution", educationInfo.getInstitution())
                .addValue("PROGRAM", educationInfo.getProgram())
                .addValue("startDate", educationInfo.getStartDate())
                .addValue("endDate", educationInfo.getEndDate()));

        String workExperienceSql = "INSERT INTO work_experience_info (resume_id, company_name, position,YEARS,RESPONSIBILITIES) VALUES (:resumeId, :companyName, :position, :YEARS, :RESPONSIBILITIES)";
        namedParameterJdbcTemplate.update(workExperienceSql, new MapSqlParameterSource()
                .addValue("resumeId", resumeId)
                .addValue("companyName", workExperienceInfo.getCompanyName())
                .addValue("position", workExperienceInfo.getPosition())
                .addValue("YEARS", workExperienceInfo.getYear())
                .addValue("RESPONSIBILITIES", workExperienceInfo.getResponsibilities()));
    }


    public void editResume(Resumes resumes) {
        String sql = """
            UPDATE resumes
            SET name = :name,
                category_id = :categoryId,
                salary = :salary,
                is_active = :isActive,
                update_time = :updateTime
            WHERE ID = :id;
            """;

        Map<String, Object> params = new HashMap<>();
        params.put("name", resumes.getName());
        params.put("categoryId", resumes.getCategoryId());
        params.put("salary", resumes.getSalary());
        params.put("isActive", resumes.isActive());
        params.put("updateTime", resumes.getUpdateTime());
        params.put("id", resumes.getId());

        namedParameterJdbcTemplate.update(sql, params);
    }

    public void deleteResume(Long resumeId) {
        String sql = "DELETE FROM resumes WHERE id = :resumeId";

        Map<String, Object> params = new HashMap<>();
        params.put("resumeId", resumeId);

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
