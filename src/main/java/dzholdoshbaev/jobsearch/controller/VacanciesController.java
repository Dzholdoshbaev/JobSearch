package dzholdoshbaev.jobsearch.controller;




import dzholdoshbaev.jobsearch.dto.UsersDto;
import dzholdoshbaev.jobsearch.dto.VacanciesDto;
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

@Controller
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacanciesController {
    private final VacanciesService vacanciesService;
    private final UsersService usersService;
    private final CategoriesService categoriesService;

    @PostMapping("/create")
    public String createVacancy(VacanciesDto vacanciesDto , Principal principal) {
        String username = principal.getName();
        UsersDto user = usersService.getUserByEmail(username);
        vacanciesService.createVacancies(vacanciesDto,user.getId());
        return "redirect:/profile";
    }

    @GetMapping("/create")
    public String createVacancy(Model model) {
        model.addAttribute("categoriesDto",categoriesService.getCategories());
        return "vacancies/create";
    }

    @PutMapping("/edit")
    public ResponseEntity<String> editVacancy( VacanciesDto vacanciesDto) {
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

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<VacanciesDto>> getResumesByCategory(@PathVariable int categoryId) {
        return ResponseEntity.ok(vacanciesService.getAllVacanciesByCategory(categoryId));
    }

    @GetMapping("/{vacanciesId}")
    public ResponseEntity<VacanciesDto> getAllResumesByUser(@PathVariable int vacanciesId) {
        return ResponseEntity.ok(vacanciesService.getVacanciesById(vacanciesId));
    }
}
