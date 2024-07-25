package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.WorkExperienceInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class WorkExperienceInfoDao {
    private final JdbcTemplate jdbcTemplate;

    public List<WorkExperienceInfo> getWorkExperienceInfo() {
        String sql = "select * from work_experience_info";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(WorkExperienceInfo.class));
    }
}
