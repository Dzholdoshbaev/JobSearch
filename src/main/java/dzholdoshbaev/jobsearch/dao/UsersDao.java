package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.Users;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UsersDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Users> getAllUsers() {
        String sql = "select * from users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Users.class));
    }

    public Users getUserByName(String name) {
        String sql = "select * from users where name = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Users.class), name);
    }

    public Users getUserByPhoneNumber(String phoneNumber) {
        String sql = "select * from users where phone_number = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Users.class), phoneNumber);
    }

    public Users getUserByEmail(String email) {
        String sql = "select * from users where email = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Users.class), email);
    }

    public Boolean checkUserByEmail(String email) {
        String sql = "select * from users where email = ?";
        Users users = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Users.class), email);
        return users != null;
    }


}
