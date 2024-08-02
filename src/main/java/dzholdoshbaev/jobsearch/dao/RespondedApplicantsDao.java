package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.RespondedApplicants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RespondedApplicantsDao {
    private final JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void  addRespondApplicants(RespondedApplicants respondApplicants) {
        String sql = "insert into responded_applicants (resume_id,vacancy_id) values ( :resumeId, :vacancyId)";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource()
        .addValue("resumeId", respondApplicants.getResumeId())
                .addValue("vacancyId", respondApplicants.getVacancyId()));
    }

    public List<RespondedApplicants> getRespondedApplicants() {
        String sql = "select * from responded_applicants";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(RespondedApplicants.class));
    }

    public List<RespondedApplicants> respondedApplicantsListByResume(int resumeId) {
        String sql = "select * from responded_applicants where resume_id = ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(RespondedApplicants.class),resumeId);
    }

    public List<RespondedApplicants> respondedApplicantsByVacancy(int vacancyId) {
        String sql = "select * from responded_applicants where vacancy_id = ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(RespondedApplicants.class),vacancyId);
    }

}
