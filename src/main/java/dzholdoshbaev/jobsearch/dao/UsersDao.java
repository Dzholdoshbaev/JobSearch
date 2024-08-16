package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.Users;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;


import java.sql.PreparedStatement;
import java.util.*;

@Component
@RequiredArgsConstructor
public class UsersDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final KeyHolder keyHolder = new GeneratedKeyHolder();

    public Integer create(Users user) {
        String sql = "insert into users (name, surname, age, email, password, phone_number, AUTHORITY_ID,ENABLED) values (?,?,?,?,?,?,?,?)";
        
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql,new String[]{"id"});
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setInt(3, user.getAge());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.setString(6, user.getPhoneNumber());
            ps.setLong(7, user.getAuthority_id());
            ps.setBoolean(8, user.isEnabled());
            return ps;
        },keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    public void addUser(Users user) {
        String sql = "insert into users (name, surname, age, email, password, phone_number, AUTHORITY_ID ,ENABLED) values (:name, :surname, :age, :email, :password, :phoneNumber, :authorityId, :enabled)";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource()
        .addValue("name", user.getName())
                .addValue("surname", user.getSurname())
                .addValue("age", user.getAge())
                .addValue("email", user.getEmail())
                .addValue("password", user.getPassword())
                .addValue("phoneNumber", user.getPhoneNumber())
                .addValue("AUTHORITY_ID",user.getAuthority_id())
                .addValue("enabled", true));
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

    public void editUser(Users user) {
        String sql = """
            UPDATE users
            SET name = :name,
                surname = :surname,
                age = :age,
                password = :password,
                PHONE_NUMBER = :phoneNumber,
                avatar = :avatar,
                enabled = :enabled,
                authority_id = :authority_id

            WHERE email = :email;
            """;

        Map<String, Object> params = new HashMap<>();
        params.put("name", user.getName());
        params.put("surname", user.getSurname());
        params.put("age", user.getAge());
        params.put("email", user.getEmail());
        params.put("password", user.getPassword());
        params.put("PHONE_NUMBER", user.getPhoneNumber());
        params.put("avatar", user.getAvatar());
        params.put("enabled",user.isEnabled());
        params.put("authority_id", user.getAuthority_id());

        namedParameterJdbcTemplate.update(sql, params);
    }
}
