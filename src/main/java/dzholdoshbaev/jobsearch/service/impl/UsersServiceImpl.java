package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.model.Users;
import dzholdoshbaev.jobsearch.repository.UsersRepository;
import dzholdoshbaev.jobsearch.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void createUser(Users users) {
        users.setAvatar("/static/images/nophoto.jpg");
        users.setEnabled(true);
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        usersRepository.save(users);
        log.info("Created user: {}", users.getEmail());
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
    public void editResume(Users usersDto) {
        log.info("Edited user");
    }
}