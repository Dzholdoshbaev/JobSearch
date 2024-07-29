package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.UsersDao;
import dzholdoshbaev.jobsearch.dto.UsersDto;
import dzholdoshbaev.jobsearch.model.Users;
import dzholdoshbaev.jobsearch.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersDao usersDao;

    @Override
    public void createUser(Users user) {
        usersDao.addUser(user);
        log.info("Created user: {}", user.getEmail());
    }

    @Override
    public UsersDto getUserById(int id){
        Users user = usersDao.getUserById(id).orElseThrow(() -> new RuntimeException("User not found"));
        UsersDto corrected = UsersDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .age(user.getAge())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .avatar(user.getAvatar())
                .accountType(user.getAccountType())
                .build();
        log.info("Printed user by id");
        return corrected;
    }

    @Override
    public List<UsersDto> getAllUsers() {
        var list = usersDao.getAllUsers();

        List<UsersDto> sorted =  list.stream()
                .map(e -> UsersDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .surname(e.getSurname())
                        .age(e.getAge())
                        .email(e.getEmail())
                        .password(e.getPassword())
                        .phoneNumber(e.getPhoneNumber())
                        .avatar(e.getAvatar())
                        .accountType(e.getAccountType())
                        .build()).toList();
        log.info("Printed all users");
        return sorted;
    }

    @Override
    public UsersDto getUserByName(String name){
        Users user = usersDao.getUserByName(name)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UsersDto corrected = UsersDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .age(user.getAge())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .avatar(user.getAvatar())
                .accountType(user.getAccountType())
                .build();
        log.info("Printed user by name");
        return corrected;

    }

    @Override
    public UsersDto getUserByPhoneNumber(String phoneNumber){
        Users user = usersDao.getUserByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UsersDto corrected = UsersDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .age(user.getAge())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .avatar(user.getAvatar())
                .accountType(user.getAccountType())
                .build();
        log.info("Printed user by phone number");
        return corrected;

    }

    @Override
    public UsersDto getUserByEmail(String email){
        Users user = usersDao.getUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UsersDto corrected = UsersDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .age(user.getAge())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .avatar(user.getAvatar())
                .accountType(user.getAccountType())
                .build();
        log.info("Printed user by email");
        return corrected;

    }

    @Override
    public Boolean checkUserByEmail(String email){
        Boolean checked = usersDao.checkUserByEmail(email);
        log.info("Checked user by email");
        return checked;
    }
}