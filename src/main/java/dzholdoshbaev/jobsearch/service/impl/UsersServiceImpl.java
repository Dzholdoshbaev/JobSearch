package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.common.Utilities;
import dzholdoshbaev.jobsearch.dto.UsersDto;
import dzholdoshbaev.jobsearch.model.Authorities;
import dzholdoshbaev.jobsearch.model.Users;
import dzholdoshbaev.jobsearch.repository.AuthoritiesRepository;
import dzholdoshbaev.jobsearch.repository.UsersRepository;
import dzholdoshbaev.jobsearch.service.UsersService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final AuthoritiesRepository authoritiesRepository;
    private final EmailService emailService;

    @Override
    public void createUser(UsersDto usersDto) {

        Authorities authority = authoritiesRepository.findById(usersDto.getAuthorityId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid authority ID"));

        Users user = Users.builder()
                .name(usersDto.getName())
                .surname(usersDto.getSurname())
                .age(usersDto.getAge())
                .email(usersDto.getEmail())
                .password(passwordEncoder.encode(usersDto.getPassword()))
                .phoneNumber(usersDto.getPhoneNumber())
                .authorities(authority)
                .enabled(true)
                .build();

        usersRepository.save(user);
        log.info("Created user: {}", user.getEmail());
    }

    @Override
    public Optional<Users> getUserById(Long id){
        return usersRepository.findById(id);
    }

    @Override
    public List<Users> getAllUsers() {
        var list = usersRepository.findAll();
        log.info("Printed all users");
        return list;
    }

    @Override
    public Users getUserByName(String name){
        log.info("Printed user by name");
        return new Users();
    }

    @Override
    public Users getUserByPhoneNumber(String phoneNumber){
        log.info("Printed user by phone number");
        return new Users();

    }

    @Override
    public Users getUserByEmail(String email){
        log.info("Printed user by email");
        List<Users> users = usersRepository.findAll();
        Users user = users.get(0);
        for (Users user1 : users) {
            if (user1.getEmail().equals(email)) {
                user = user1;
            }
        }
        return user;
    }

    @Override
    public Boolean checkUserByEmail(String email){
        log.info("Checked user by email");
        return true;
    }

    @Override
    public void editResume(Users usersDto , String userEmail) {

        usersRepository.updateUsersByEmail(userEmail,
                usersDto.getEmail(),
                usersDto.getName(),
                usersDto.getSurname(),
                usersDto.getAge(),
                passwordEncoder.encode(usersDto.getPassword()),
                usersDto.getPhoneNumber());

        log.info("Edited user");
    }

    @Override
    public Map<String, Object> forgotPassword(HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        try {
            makeResetPasswordLink(request);
            model.put("message", "we have sent reset password link to your email. Please check.");
        } catch (UsernameNotFoundException | UnsupportedEncodingException e) {
            model.put("error", e.getMessage());
        } catch (MessagingException e) {
            model.put("error", "Error while sending reset password link to your email.");
        }
        return model;
    }

    @Override
    public Map<String, Object> resetPasswordGet(String token) {
        Map<String, Object> model = new HashMap<>();
        try {
            getByToken(token);
            model.put("token", token);
        } catch (UsernameNotFoundException e) {
            model.put("error", "Invalid token");
        }
        return model;
    }

    @Override
    public Map<String, Object> resetPasswordPost(HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        String token = request.getParameter("token");
        String password = request.getParameter("password");

        try {
            Users user = getByToken(token);
            updatePassword(user, password);
            model.put("message", "You have successfully changed your password.");
        } catch (UsernameNotFoundException e) {
            model.put("message", "Invalid token");
        }
        return model;
    }

    private void makeResetPasswordLink(HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        String email = request.getParameter("email");
        String token = UUID.randomUUID().toString();
        updateToken(token, email);

        String resetPasswordLink = Utilities.getSiteUrl(request) + "/auth/reset_password?token=" + token;
        emailService.sendMail(email, resetPasswordLink);
    }

    private Users getByToken(String token) {
        return usersRepository.findByResetPasswordToken(token)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    private void updatePassword(Users user, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        user.setResetPasswordToken(null);
        usersRepository.save(user);
    }

    private void updateToken(String token, String email) {
        Users user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Could not find any user with the email: " + email));
        user.setResetPasswordToken(token);
        usersRepository.save(user);
    }
}