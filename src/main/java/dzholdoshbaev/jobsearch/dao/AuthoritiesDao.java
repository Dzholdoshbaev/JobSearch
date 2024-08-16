package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.Authorities;
import dzholdoshbaev.jobsearch.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthoritiesDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Authorities> findAll() {
        String sql = "select * from authorities";
        List<Authorities> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Authorities.class));
        return list;
    }
}
