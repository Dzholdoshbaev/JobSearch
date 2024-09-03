package dzholdoshbaev.jobsearch.service;


import dzholdoshbaev.jobsearch.dto.UserDtoEdit;
import dzholdoshbaev.jobsearch.dto.UsersDto;
import dzholdoshbaev.jobsearch.model.Users;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UsersService {
    void createUser(UsersDto usersDto );

    Map<String, Object> resetPasswordGet(String token);

    Map<String, Object> resetPasswordPost(HttpServletRequest request);

    Optional<Users> getUserById(Long id);

    List<Users> getAllUsers();

    Users getUserByName(String name);

    Users getUserByPhoneNumber(String phoneNumber);

    Users getUserByEmail(String email);

    Boolean checkUserByEmail(String email);

    void editResume(UserDtoEdit usersDto , String userEmail);

    Map<String, Object> forgotPassword(HttpServletRequest request);
}
