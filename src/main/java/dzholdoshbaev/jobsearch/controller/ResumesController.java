package dzholdoshbaev.jobsearch.controller;


import dzholdoshbaev.jobsearch.dto.ResumesDto;

import dzholdoshbaev.jobsearch.model.Resumes;
import dzholdoshbaev.jobsearch.service.ResumesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/resumes")
@RequiredArgsConstructor
public class ResumesController {
    private final ResumesService resumesService;

    @PostMapping("/create")
    public ResponseEntity<String> createResume(@RequestBody Resumes resume) {
        resumesService.createResumes(resume);
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

    @GetMapping
    public ResponseEntity<List<ResumesDto>> getAllResumes() {
        return ResponseEntity.ok(resumesService.getAllResumes());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ResumesDto>> getAllResumesByCategory(@PathVariable int categoryId) {
        return ResponseEntity.ok(resumesService.getAllResumesByCategory(categoryId));
    }

    @GetMapping("/applicant/{applicantId}")
    public ResponseEntity<List<ResumesDto>> getAllResumesByUser(@PathVariable int applicantId) {
        return ResponseEntity.ok(resumesService.getAllResumesByUser(applicantId));
    }


}
