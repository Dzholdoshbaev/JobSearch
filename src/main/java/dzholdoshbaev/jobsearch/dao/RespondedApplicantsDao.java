package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.RespondedApplicants;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RespondedApplicantsDao {
    private final JdbcTemplate jdbcTemplate;

    public List<RespondedApplicants> getRespondedApplicants() {
        String sql = "select * from responded_applicants";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(RespondedApplicants.class));
    }

    public List<RespondedApplicants> respondedApplicantsList(int resumeId) {
        String sql = "select * from responded_applicants where resume_id = ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(RespondedApplicants.class),resumeId);
    }

    public List<RespondedApplicants> respondedApplicantsByVacancy(int vacancyId) {
        String sql = "select * from responded_applicants where vacancy_id = ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(RespondedApplicants.class),vacancyId);
    }

}
