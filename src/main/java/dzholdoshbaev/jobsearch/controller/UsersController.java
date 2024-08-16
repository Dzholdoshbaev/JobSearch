package dzholdoshbaev.jobsearch.controller;


import dzholdoshbaev.jobsearch.dto.UsersDto;


import dzholdoshbaev.jobsearch.service.AuthoritiesService;
import dzholdoshbaev.jobsearch.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    private final AuthoritiesService authoritiesService;

    @GetMapping
    public ResponseEntity<List<UsersDto>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<UsersDto> getUserByName(@PathVariable String name) {
        return ResponseEntity.ok(usersService.getUserByName(name));
    }

    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<UsersDto> getUserByPhoneNumber(@PathVariable String phoneNumber) {
        return ResponseEntity.ok(usersService.getUserByPhoneNumber(phoneNumber));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsersDto> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(usersService.getUserByEmail(email));
    }

    @GetMapping("/check/{email}")
    public ResponseEntity<Boolean> checkUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(usersService.checkUserByEmail(email));
    }
}
