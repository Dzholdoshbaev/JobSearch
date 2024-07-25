package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.ContactsInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContactsInfoDao {
    private final JdbcTemplate jdbcTemplate;

    public List<ContactsInfo> getAllContactsInfo() {
        String sql = "select * from contacts_info";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(ContactsInfo.class));
    }
}
