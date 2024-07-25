package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.EducationInfo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EducationInfoDao {
    private final JdbcTemplate jdbcTemplate;

    public List<EducationInfo> getAllEducationInfo() {
        String sql = "select * from education_info";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(EducationInfo.class));
    }
}
