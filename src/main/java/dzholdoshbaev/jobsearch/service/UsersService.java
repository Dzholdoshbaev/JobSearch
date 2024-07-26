package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.dto.UsersDto;
import dzholdoshbaev.jobsearch.model.Users;

import java.util.List;

public interface UsersService {
    void createUser(Users user);

    UsersDto getUserById(int id);

    List<UsersDto> getAllUsers();

    UsersDto getUserByName(String name);

    UsersDto getUserByPhoneNumber(String phoneNumber);

    UsersDto getUserByEmail(String email);

    Boolean checkUserByEmail(String email);
}
