package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.ContactTypes;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContactTypesDao {
    private final JdbcTemplate jdbcTemplate;

    public List<ContactTypes> getAllContactTypes() {
        String sql = "select * from contact_types";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(ContactTypes.class));
    }
}
