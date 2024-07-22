package dzholdoshbaev.jobsearch.controller;


import dzholdoshbaev.jobsearch.dto.UsersDto;
import dzholdoshbaev.jobsearch.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<String> registerEmployer(@RequestBody UsersDto usersDto) {
        usersService.createUser(usersDto);
        return ResponseEntity.ok("Пользователь успешно зарегистрирован");
    }
}
