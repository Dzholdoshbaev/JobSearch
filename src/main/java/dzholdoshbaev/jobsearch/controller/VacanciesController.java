package dzholdoshbaev.jobsearch.controller;




import dzholdoshbaev.jobsearch.dto.VacanciesDto;
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

    @PostMapping("/create")
    public String createVacancy(VacanciesDto vacanciesDto , Principal principal, Model model) {
        vacanciesService.createVacancies(vacanciesDto);
        return "redirect:/profile";
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
