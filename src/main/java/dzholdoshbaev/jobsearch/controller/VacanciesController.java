package dzholdoshbaev.jobsearch.controller;




import dzholdoshbaev.jobsearch.model.Resumes;
import dzholdoshbaev.jobsearch.model.Users;
import dzholdoshbaev.jobsearch.model.Vacancies;
import dzholdoshbaev.jobsearch.service.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;


import java.security.Principal;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;


@Controller
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacanciesController {
    private final VacanciesService vacanciesService;
    private final UsersService usersService;
    private final CategoriesService categoriesService;
    private final ResumesService resumesService;
    private final RespondedApplicantsService respondedApplicantsService;

    @PostMapping("/create")
    public String createVacancy(@ModelAttribute @Valid Vacancies vacancies,
                                BindingResult bindingResult , Principal principal ,
                                Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("categoriesDto", categoriesService.getCategories());
            return "vacancies/create";
        }

        String username = principal.getName();
        Users user = usersService.getUserByEmail(username);
        vacancies.setUsers(user);
        vacanciesService.createVacancies(vacancies);
        return "redirect:/profile";
    }

    @PostMapping("/respond/{vacancyId}")
    public String respond(@PathVariable Long vacancyId, @RequestParam(name = "resumeId", required = false) Long resumeId, Model model, Principal principal, Locale locale) {
        String username = principal.getName();
        Users user = usersService.getUserByEmail(username);
        Vacancies vacancies = vacanciesService.getVacanciesById(vacancyId);

        if (vacancies == null) {
            throw new NoSuchElementException("No such vacancy found");
        }

        if (resumeId == null || resumesService.getResumeById(resumeId) == null) {
            String message = locale.getLanguage().equals("en")
                    ? "You must select a resume to respond to the vacancy."
                    : "Для отклика на вакансию необходимо выбрать резюме.";

            List<Resumes> userResume = resumesService.getAllResumesByUser(user.getId());
            model.addAttribute("vacancy", vacancies);
            model.addAttribute("userResumes", userResume);
            model.addAttribute("errorMessage", message);
            return "vacancies/vacancy";
        }

        Resumes resumes = resumesService.getResumeById(resumeId);
        respondedApplicantsService.createRespond(vacancyId, resumes, user);
        return "redirect:/profile";
    }


    @GetMapping("/create")
    public String createVacancy(Model model) {
        model.addAttribute("categoriesDto", categoriesService.getCategories());
        model.addAttribute("vacancies", new Vacancies());
        return "vacancies/create";
    }


    @GetMapping("/update/{vacancyId}")
    public String updateVacancy(@PathVariable Long vacancyId){
        vacanciesService.updateVacancy(vacancyId);
        return "redirect:/profile";
    }


    @PostMapping("/edit/{vacancyId}")
    public String editVacancy(@ModelAttribute @Valid Vacancies vacancies,
                              BindingResult bindingResult ,
                              @PathVariable Long vacancyId ,
                              Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("categoriesDto", categoriesService.getCategories());
            model.addAttribute("vacancyId",vacancyId);
            return "vacancies/editVacancy";
        }

        vacanciesService.editVacancy(vacancies,vacancyId);
        return "redirect:/profile" ;
    }

    @GetMapping("/edit/{vacancyId}")
    public String editVacancy(@PathVariable Long vacancyId ,Model model) {
        model.addAttribute("categoriesDto",categoriesService.getCategories());
        model.addAttribute("vacancyId",vacancyId);
        model.addAttribute("vacancies", new Vacancies());
        return "vacancies/editVacancy";
    }

    @DeleteMapping("/delete/{vacancyId}")
    public ResponseEntity<String> deleteVacancy(@PathVariable Long vacancyId) {
        vacanciesService.deleteVacancy(vacancyId);
        return ResponseEntity.ok("Вакансия успешно удалена");
    }

    @GetMapping
    public String getAllVacancies(
            @RequestParam(value = "sort", defaultValue = "createdDate") String sort,
            Model model,
            @PageableDefault(size = 5) Pageable pageable) {

        Sort sortBy = Sort.by(Sort.Order.asc(sort));
        Pageable sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sortBy);

        Page<Vacancies> vacanciesPage = vacanciesService.getAllVacancies(sortedPageable);
        model.addAttribute("vacancies", vacanciesPage);
        model.addAttribute("sort", sort);

        return "vacancies/vacancies";
    }


    @GetMapping("/{vacancyId}")
    public String getVacancy(@PathVariable Long vacancyId, Model model, Principal principal) {
        Vacancies vacancies = vacanciesService.getVacanciesById(vacancyId);
        if (vacancies == null) {
            throw new NoSuchElementException("No such vacancy found");
        }
        String username = principal.getName();
        Users user = usersService.getUserByEmail(username);
        List<Resumes> userResume = resumesService.getAllResumesByUser(user.getId());
        model.addAttribute("vacancy", vacancies);
        model.addAttribute("userResumes", userResume);
        return "vacancies/vacancy";
    }
}
