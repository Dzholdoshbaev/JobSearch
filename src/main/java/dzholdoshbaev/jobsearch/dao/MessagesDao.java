package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.Messages;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MessagesDao {
    private final JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Messages> getAllMessages() {
        String sql = "select * from messages";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Messages.class));
    }
}
