package dzholdoshbaev.jobsearch.controller;

import dzholdoshbaev.jobsearch.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final UsersService usersService;

    @GetMapping("/login")
    public String login() {
        return "profile/login";
    }
}
