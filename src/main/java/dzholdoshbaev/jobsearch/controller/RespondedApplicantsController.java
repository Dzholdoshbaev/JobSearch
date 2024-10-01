package dzholdoshbaev.jobsearch.controller;



import dzholdoshbaev.jobsearch.model.RespondedApplicants;
import dzholdoshbaev.jobsearch.model.Users;
import dzholdoshbaev.jobsearch.service.RespondedApplicantsService;
import dzholdoshbaev.jobsearch.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/applicants")
@RequiredArgsConstructor
public class RespondedApplicantsController {
    private final UsersService usersService;
    private final RespondedApplicantsService respondedApplicantsService;


    @GetMapping("respond")
    public String respondApplicants(Model model, Principal principal) {
        String username = principal.getName();
        Users user = usersService.getUserByEmail(username);
        List<RespondedApplicants> respondedApplicantsList = respondedApplicantsService.findByUser(user);
        model.addAttribute("respondedApplicantsList", respondedApplicantsList);
        model.addAttribute("users", user);
        return "profile/respond";

    }

    @GetMapping("/confirm/{respondId}")
    public String confirmApplicant(@PathVariable Long respondId, Model model, Principal principal) {
        String username = principal.getName();
        Users user = usersService.getUserByEmail(username);
        respondedApplicantsService.confirmREspond(user,respondId);
        return "redirect:/applicants/respond";
    }
}
