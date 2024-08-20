package dzholdoshbaev.jobsearch.controller;

import dzholdoshbaev.jobsearch.dao.ResumesDao;
import dzholdoshbaev.jobsearch.dao.VacanciesDao;
import dzholdoshbaev.jobsearch.dto.AuthoritiesDto;
import dzholdoshbaev.jobsearch.dto.ResumesDto;
import dzholdoshbaev.jobsearch.dto.UsersDto;
import dzholdoshbaev.jobsearch.dto.VacanciesDto;
import dzholdoshbaev.jobsearch.service.AuthoritiesService;
import dzholdoshbaev.jobsearch.service.ResumesService;
import dzholdoshbaev.jobsearch.service.UsersService;
import dzholdoshbaev.jobsearch.service.VacanciesService;
import jakarta.validation.Valid;
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
       UsersDto user = usersService.getUserByEmail(username);
       model.addAttribute("userDto", user);
        if (user.getAuthorityId() == 1){
            List<ResumesDto> resumes = resumesService.getAllResumesByUser(user.getId());
            model.addAttribute("resumes", resumes);
        }else {
            List<VacanciesDto> vacancies = vacanciesService.getAllVacanciesByUser(user.getId());
            model.addAttribute("vacancies", vacancies);
        }
       return "profile/profile";
    }

    @PostMapping("/register")
    public String register( UsersDto usersDto , BindingResult bindingResult , Model model) {
//        var user = usersService.getUserByEmail(usersDto.getEmail());
//        if (user == null) {
//            return "redirect:profile/profile";
//        }
//
//        if (!bindingResult.hasErrors()) {
//            usersService.createUser(usersDto);
//            return "redirect:/";
//        }

        usersService.createUser(usersDto);

        model.addAttribute("usersDto", usersDto);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String create(Model model) {
        model.addAttribute("authoritiesUser", authoritiesService.getAllAuthorities());
        model.addAttribute("usersDto", new UsersDto());
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
