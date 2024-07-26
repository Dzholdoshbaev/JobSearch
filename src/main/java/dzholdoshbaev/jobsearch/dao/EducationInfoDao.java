package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.EducationInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EducationInfoDao {
    private final JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<EducationInfo> getAllEducationInfo() {
        String sql = "select * from education_info";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(EducationInfo.class));
    }
}
