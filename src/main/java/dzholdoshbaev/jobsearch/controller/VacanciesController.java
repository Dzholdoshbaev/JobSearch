package dzholdoshbaev.jobsearch.controller;




import dzholdoshbaev.jobsearch.model.Users;
import dzholdoshbaev.jobsearch.model.Vacancies;
import dzholdoshbaev.jobsearch.service.CategoriesService;
import dzholdoshbaev.jobsearch.service.UsersService;
import dzholdoshbaev.jobsearch.service.VacanciesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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

    @PutMapping("/edit")
    public ResponseEntity<String> editVacancy( Vacancies vacanciesDto) {
        vacanciesService.editVacancy(vacanciesDto);
        return ResponseEntity.ok("Вакансия успешно отредактирована");
    }

    @DeleteMapping("/delete/{vacancyId}")
    public ResponseEntity<String> deleteVacancy(@PathVariable Long vacancyId) {
        vacanciesService.deleteVacancy(vacancyId);
        return ResponseEntity.ok("Вакансия успешно удалена");
    }

    @GetMapping
    public String getAllVacancies(Model model) {
        model.addAttribute("vacancies", vacanciesService.getAllVacancies());
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
