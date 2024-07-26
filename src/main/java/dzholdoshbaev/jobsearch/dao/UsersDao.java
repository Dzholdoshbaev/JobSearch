package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@RequiredArgsConstructor
public class UsersDao {
    private final JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void addUser(Users user) {
        String sql = "insert into users (name, surname, age, email, password, phone_number, account_type) values (:name, :surname, :age, :email, :password, :phoneNumber, :accountType)";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource()
        .addValue("name", user.getName())
                .addValue("surname", user.getSurname())
                .addValue("age", user.getAge())
                .addValue("email", user.getEmail())
                .addValue("password", user.getPassword())
                .addValue("phone_number", user.getPhoneNumber())
                .addValue("account_type",user.getAccountType()));

    }

    public List<Users> getAllUsers() {
        String sql = "select * from users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Users.class));
    }

    public Optional<Users> getUserById(int id) {
        String sql = "select * from users where id = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Users.class),id)
                )
        );
    }

    public Optional<Users> getUserByName(String name) {
        String sql = "select * from users where name = ?";
        Users user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Users.class), name);
        return Optional.ofNullable(user);
    }

    public Optional<Users> getUserByPhoneNumber(String phoneNumber) {
        String sql = "select * from users where phone_number = ?";
        Users user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Users.class), phoneNumber);
        return Optional.ofNullable(user);
    }

    public Optional<Users> getUserByEmail(String email) {
        String sql = "select * from users where email = ?";
        Users user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Users.class), email);
        return Optional.ofNullable(user);
    }

    public Boolean checkUserByEmail(String email) {
        String sql = "select * from users where email = ?";
        Users users = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Users.class), email);
        return users != null;
    }


}
