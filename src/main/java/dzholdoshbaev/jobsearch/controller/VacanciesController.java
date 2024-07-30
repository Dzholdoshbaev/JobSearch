package dzholdoshbaev.jobsearch.controller;



import dzholdoshbaev.jobsearch.dto.ResumesDto;
import dzholdoshbaev.jobsearch.dto.VacanciesDto;
import dzholdoshbaev.jobsearch.model.Vacancies;
import dzholdoshbaev.jobsearch.service.VacanciesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacanciesController {
    private final VacanciesService vacanciesService;

    @PostMapping("/create")
    public ResponseEntity<String> createVacancy(@RequestBody Vacancies vacancies) {
        vacanciesService.createVacancies(vacancies);
        return ResponseEntity.ok("Вакансия успешно создана");
    }

    @PutMapping("/edit/{vacancyId}")
    public ResponseEntity<String> editVacancy(@PathVariable Long vacancyId, @RequestBody VacanciesDto vacanciesDto) {
        vacanciesService.editVacancy(vacancyId,vacanciesDto);
        return ResponseEntity.ok("Вакансия успешно отредактирована");
    }

    @DeleteMapping("/delete/{vacancyId}")
    public ResponseEntity<String> deleteVacancy(@PathVariable Long vacancyId) {
        vacanciesService.deleteVacancy(vacancyId);
        return ResponseEntity.ok("Вакансия успешно удалена");
    }

    @GetMapping
    public ResponseEntity<List<VacanciesDto>> getAllVacancies() {
        return ResponseEntity.ok(vacanciesService.getAllVacancies());
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
