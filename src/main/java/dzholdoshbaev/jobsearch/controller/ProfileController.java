package dzholdoshbaev.jobsearch.controller;

import dzholdoshbaev.jobsearch.dto.UserDtoEdit;
import dzholdoshbaev.jobsearch.dto.UsersDto;
import dzholdoshbaev.jobsearch.model.*;
import dzholdoshbaev.jobsearch.service.AuthoritiesService;
import dzholdoshbaev.jobsearch.service.ResumesService;
import dzholdoshbaev.jobsearch.service.UsersService;
import dzholdoshbaev.jobsearch.service.VacanciesService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final UsersService usersService;
    private final AuthoritiesService authoritiesService;
    private final ResumesService resumesService;
    private final VacanciesService vacanciesService;


    @GetMapping("company/{companyId}")
    public String profileCompany(@PathVariable Long companyId, Model model) {

        Optional<Users> user = usersService.getUserById(companyId);
        if(user.isEmpty()){
            throw new NoSuchElementException("no such company found");
        }
        model.addAttribute("userDto", user.get());
        return "profile/company";
    }


    @GetMapping
    public String profile(Model model, Principal principal) {
        String username = principal.getName();
        Users user = usersService.getUserByEmail(username);
        Long authorityId = user.getAuthorities().getId();
        System.out.println(authorityId);
        model.addAttribute("userDto", user);
        if (authorityId == 1){
            List<Resumes> resumes = resumesService.getAllResumesByUser(user.getId());
            model.addAttribute("resumes", resumes);
        }else {
            List<Vacancies> vacancies = vacanciesService.getAllVacanciesByUser(user.getId());
            model.addAttribute("vacancies", vacancies);
        }
        return "profile/profile";
    }


    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute @Valid UsersDto usersDto,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("authoritiesUser", authoritiesService.getAllAuthorities());
            return "profile/register";
        }

        usersService.createUser(usersDto);
        return "redirect:/auth/login";
    }


    @GetMapping("/register")
    public String create(Model model) {
        model.addAttribute("authoritiesUser", authoritiesService.getAllAuthorities());
        model.addAttribute("usersDto", new UsersDto());
        return "profile/register";
    }

    @PostMapping("/edit")
    public String editResume(@ModelAttribute @Valid UserDtoEdit usersDto,
                             BindingResult bindingResult,
                             Principal principal,
                             HttpServletRequest request,
                             HttpServletResponse response) {

        if (bindingResult.hasErrors()) {
            return "users/editUser";
        }

        String username = principal.getName();
        usersService.editResume(usersDto, username);

        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, response, (Authentication) principal);

        return "redirect:/auth/login";
    }

    @GetMapping("/edit")
    public String editResume(Model model) {
        model.addAttribute("userDtoEdit", new UserDtoEdit());
        return "users/editUser";
    }
}
