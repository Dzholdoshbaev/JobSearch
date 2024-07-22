package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.Users;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class UsersDao {
    private List<Users> usersList = new ArrayList<>();
}
