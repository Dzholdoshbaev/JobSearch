package dzholdoshbaev.jobsearch.service;


import dzholdoshbaev.jobsearch.model.Users;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UsersService {
    void createUser(Users users );

    Map<String, Object> resetPasswordGet(String token);

    Map<String, Object> resetPasswordPost(HttpServletRequest request);

    Optional<Users> getUserById(Long id);

    List<Users> getAllUsers();

    Users getUserByName(String name);

    Users getUserByPhoneNumber(String phoneNumber);

    Users getUserByEmail(String email);

    Boolean checkUserByEmail(String email);

    void editResume(Users usersDto ,String userEmail);

    Map<String, Object> forgotPassword(HttpServletRequest request);
}
