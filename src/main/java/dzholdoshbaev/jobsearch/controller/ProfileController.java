package dzholdoshbaev.jobsearch.controller;

import dzholdoshbaev.jobsearch.dto.UsersDto;
import dzholdoshbaev.jobsearch.model.Users;
import dzholdoshbaev.jobsearch.service.AuthoritiesService;
import dzholdoshbaev.jobsearch.service.UsersService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;


@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final UsersService usersService;
    private final AuthoritiesService authoritiesService;

    @GetMapping
    public String profile(Model model) {
       String username = "urmat@gmail.com";
       UsersDto user = usersService.getUserByEmail(username);
       model.addAttribute("user", user);
       return "profile/profile";
    }

    @PostMapping("/register")
    public String register(@RequestBody @Valid UsersDto usersDto) {
        usersService.createUser(usersDto);
        return "profile/profile";
    }

    @GetMapping("/register")
    public String create(Model model) {
        model.addAttribute("authorities", authoritiesService.getAllAuthorities());
        return "profile/register";
    }

    @PutMapping("/edit")
    public String editResume(@RequestBody @Valid UsersDto usersDto) {
        usersService.editResume(usersDto);
        return "profile/profile";
    }

    @GetMapping("/edit")
    public String editResume(Model model) {
        model.addAttribute("authorities", authoritiesService.getAllAuthorities());
        return "users/editUser";
    }
}
