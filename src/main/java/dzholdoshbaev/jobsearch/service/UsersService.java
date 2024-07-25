package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.dto.UsersDto;

import java.util.List;

public interface UsersService {
    void createUser(UsersDto usersDto);

    List<UsersDto> getAllUsers();

    UsersDto getUserByName(String name);

    UsersDto getUserByPhoneNumber(String phoneNumber);

    UsersDto getUserByEmail(String email);

    Boolean checkUserByEmail(String email);
}
