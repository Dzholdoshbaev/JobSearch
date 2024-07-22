package dzholdoshbaev.jobsearch.controller;


import dzholdoshbaev.jobsearch.dto.ResumesDto;
import dzholdoshbaev.jobsearch.dto.VacanciesDto;
import dzholdoshbaev.jobsearch.service.VacanciesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacanciesController {
    private final VacanciesService vacanciesService;

    @PostMapping("/create")
    public ResponseEntity<String> createVacancy(@RequestBody VacanciesDto vacanciesDto) {
        vacanciesService.createVacancies(vacanciesDto);
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

    @GetMapping("/resumes")
    public ResponseEntity<List<ResumesDto>> getAllResumes() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping("/resumes/{category}")
    public ResponseEntity<List<ResumesDto>> getResumesByCategory(@PathVariable String category) {
        return ResponseEntity.ok(new ArrayList<>());
    }
}
