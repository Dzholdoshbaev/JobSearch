package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dto.UsersDto;
import dzholdoshbaev.jobsearch.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Override
    public void createUser(UsersDto usersDto) {
        System.out.println(usersDto);
    }
}
