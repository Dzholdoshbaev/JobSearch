package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.Messages;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MessagesDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Messages> getAllMessages() {
        String sql = "select * from messages";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Messages.class));
    }
}
