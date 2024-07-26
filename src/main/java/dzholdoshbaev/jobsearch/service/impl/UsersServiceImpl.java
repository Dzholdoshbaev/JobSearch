package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.UsersDao;
import dzholdoshbaev.jobsearch.dto.UsersDto;
import dzholdoshbaev.jobsearch.model.Users;
import dzholdoshbaev.jobsearch.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersDao usersDao;

    @Override
    public void createUser(Users user) {
        usersDao.addUser(user);
    }

    @Override
    public UsersDto getUserById(int id){
        Users user = usersDao.getUserById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UsersDto.builder()
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
    }

    @Override
    public List<UsersDto> getAllUsers() {
        var list = usersDao.getAllUsers();

        return list.stream()
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
    }

    @Override
    public UsersDto getUserByName(String name){
        Users user = usersDao.getUserByName(name)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UsersDto.builder()
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

    }

    @Override
    public UsersDto getUserByPhoneNumber(String phoneNumber){
        Users user = usersDao.getUserByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UsersDto.builder()
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

    }

    @Override
    public UsersDto getUserByEmail(String email){
        Users user = usersDao.getUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UsersDto.builder()
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

    }

    @Override
    public Boolean checkUserByEmail(String email){
       return usersDao.checkUserByEmail(email);
    }
}