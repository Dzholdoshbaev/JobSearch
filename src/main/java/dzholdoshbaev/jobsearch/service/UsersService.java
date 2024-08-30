package dzholdoshbaev.jobsearch.service;


import dzholdoshbaev.jobsearch.model.Authorities;
import dzholdoshbaev.jobsearch.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    void createUser(Users users );

    Optional<Users> getUserById(Long id);

    List<Users> getAllUsers();

    Users getUserByName(String name);

    Users getUserByPhoneNumber(String phoneNumber);

    Users getUserByEmail(String email);

    Boolean checkUserByEmail(String email);

    void editResume(Users usersDto ,String userEmail);
}
