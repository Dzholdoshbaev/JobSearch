package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.model.Authorities;
import dzholdoshbaev.jobsearch.model.Users;
import dzholdoshbaev.jobsearch.repository.AuthoritiesRepository;
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
    private final AuthoritiesRepository authoritiesRepository;

    @Override
    public void createUser(Users user) {
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Authorities authority = authoritiesRepository.findById(user.getAuthorities().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid authority ID"));

        user.setAuthorities(authority);

        usersRepository.save(user);
        log.info("Created user: {}", user.getEmail());
    }

    private Authorities findAuthorities(List<Authorities> list, Long id) {
        for (Authorities authorities : list) {
            if (authorities.getId().equals(id)) {
                return authorities;
            }
        }
        return null;
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
}