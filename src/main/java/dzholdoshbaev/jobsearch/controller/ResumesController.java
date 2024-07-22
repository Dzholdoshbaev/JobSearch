package dzholdoshbaev.jobsearch.controller;


import dzholdoshbaev.jobsearch.dto.ResumesDto;
import dzholdoshbaev.jobsearch.dto.VacanciesDto;
import dzholdoshbaev.jobsearch.service.ResumesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/resumes")
@RequiredArgsConstructor
public class ResumesController {
    private final ResumesService resumesService;

    @PostMapping("/create")
    public ResponseEntity<String> createResume(@RequestBody ResumesDto resumeDto) {
        resumesService.createResumes(resumeDto);
        return ResponseEntity.ok("Резюме успешно создано");
    }

    @PutMapping("/edit/{resumeId}")
    public ResponseEntity<String> editResume(@PathVariable Long resumeId, @RequestBody ResumesDto resumeDto) {
        resumesService.editResume(resumeId,resumeDto);
        return ResponseEntity.ok("Резюме успешно отредактировано");
    }

    @DeleteMapping("/delete/{resumeId}")
    public ResponseEntity<String> deleteResume(@PathVariable Long resumeId) {
        resumesService.deleteResume(resumeId);
        return ResponseEntity.ok("Резюме успешно удалено");
    }

    @GetMapping("/vacancies")
    public ResponseEntity<List<VacanciesDto>> getAllActiveVacancies() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping("/vacancies/{category}")
    public ResponseEntity<List<VacanciesDto>> getVacanciesByCategory(@PathVariable String category) {
        return ResponseEntity.ok(new ArrayList<>());
    }
}
