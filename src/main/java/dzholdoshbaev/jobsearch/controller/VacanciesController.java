package dzholdoshbaev.jobsearch.controller;




import dzholdoshbaev.jobsearch.model.Users;
import dzholdoshbaev.jobsearch.model.Vacancies;
import dzholdoshbaev.jobsearch.service.CategoriesService;
import dzholdoshbaev.jobsearch.service.UsersService;
import dzholdoshbaev.jobsearch.service.VacanciesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;


import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacanciesController {
    private final VacanciesService vacanciesService;
    private final UsersService usersService;
    private final CategoriesService categoriesService;

    @PostMapping("/create")
    public String createVacancy(@ModelAttribute Vacancies vacancies, Principal principal) {
        String username = principal.getName();
        Users user = usersService.getUserByEmail(username);
        vacancies.setUsers(user);
        vacanciesService.createVacancies(vacancies);
        return "redirect:/profile";
    }


    @GetMapping("/create")
    public String createVacancy(Model model) {
        model.addAttribute("categoriesDto",categoriesService.getCategories());
        return "vacancies/create";
    }

    @GetMapping("/update/{vacancyId}")
    public String updateVacancy(@PathVariable Long vacancyId){
        vacanciesService.updateVacancy(vacancyId);
        return "redirect:/profile";
    }


    @PostMapping("/edit/{vacancyId}")
    public String editVacancy(@PathVariable Long vacancyId , Vacancies vacancies) {
        vacanciesService.editVacancy(vacancies,vacancyId);
        return "redirect:/profile" ;
    }

    @GetMapping("/edit/{vacancyId}")
    public String editVacancy(@PathVariable Long vacancyId ,Model model) {
        model.addAttribute("categoriesDto",categoriesService.getCategories());
        model.addAttribute("vacancyId",vacancyId);
        return "vacancies/editVacancy";
    }

    @DeleteMapping("/delete/{vacancyId}")
    public ResponseEntity<String> deleteVacancy(@PathVariable Long vacancyId) {
        vacanciesService.deleteVacancy(vacancyId);
        return ResponseEntity.ok("Вакансия успешно удалена");
    }

    @GetMapping
    public String getAllVacancies(Model model,@PageableDefault(size = 5, sort = "respondedApplicantsList") Pageable pageable) {
        model.addAttribute("vacancies", vacanciesService.getAllVacancies(pageable));
        return "vacancies/vacancies";
    }

    @GetMapping("/{vacancyId}")
    public String getVacancy(@PathVariable Long vacancyId ,Model model) {

        Vacancies vacancies = vacanciesService.getVacanciesById(vacancyId);

        if(vacancies == null) {
            throw new NoSuchElementException("no such vacancy found");
        }

        model.addAttribute("vacancy", vacancies);
        return "vacancies/vacancy";
    }

//    @GetMapping("/category/{categoryId}")
//    public ResponseEntity<List<Vacancies>> getResumesByCategory(@PathVariable Long categoryId) {
//        return ResponseEntity.ok(vacanciesService.getAllVacanciesByCategory(categoryId));
//    }
//
//    @GetMapping("/{vacanciesId}")
//    public ResponseEntity<Vacancies> getAllResumesByUser(@PathVariable Long vacanciesId) {
//        return ResponseEntity.ok(vacanciesService.getVacanciesById(vacanciesId));
//    }
}
