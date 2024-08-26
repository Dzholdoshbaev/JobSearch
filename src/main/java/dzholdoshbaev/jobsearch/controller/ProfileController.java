package dzholdoshbaev.jobsearch.controller;

import dzholdoshbaev.jobsearch.model.Resumes;
import dzholdoshbaev.jobsearch.model.Users;
import dzholdoshbaev.jobsearch.model.Vacancies;
import dzholdoshbaev.jobsearch.service.AuthoritiesService;
import dzholdoshbaev.jobsearch.service.ResumesService;
import dzholdoshbaev.jobsearch.service.UsersService;
import dzholdoshbaev.jobsearch.service.VacanciesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final UsersService usersService;
    private final AuthoritiesService authoritiesService;
    private final ResumesService resumesService;
    private final VacanciesService vacanciesService;

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
    public String registerUser(@ModelAttribute Users user) {
        usersService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String create(Model model) {
        model.addAttribute("authoritiesUser", authoritiesService.getAllAuthorities());
        model.addAttribute("usersDto", new Users());
        return "profile/register";
    }

    @PostMapping("/edit")
    public String editResume( Users usersDto , Principal principal) {
        String username = principal.getName();
        usersService.editResume(usersDto, username);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editResume() {
        return "users/editUser";
    }
}
