package dzholdoshbaev.jobsearch.controller;


import dzholdoshbaev.jobsearch.dto.RespondedApplicantsDto;
import dzholdoshbaev.jobsearch.dto.ResumesDto;
import dzholdoshbaev.jobsearch.service.RespondedApplicantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicants")
@RequiredArgsConstructor
public class RespondedApplicantsController {
    private final RespondedApplicantsService respondedApplicantsService;

    @PostMapping("/responded/{vacancyId}")
    public ResponseEntity<String> respondToVacancy(@PathVariable Long vacancyId, @RequestBody RespondedApplicantsDto respondedApplicantsDto) {
        return ResponseEntity.ok("Отклик на вакансию отправлен успешно");
    }

    @GetMapping
    public ResponseEntity<List<RespondedApplicantsDto>> getRespondedApplicants() {
        return ResponseEntity.ok(respondedApplicantsService.getRespondedApplicants());
    }

    @GetMapping("/resume/{resumeId}")
    public ResponseEntity<List<RespondedApplicantsDto>> respondedApplicantsListByResume(@PathVariable int resumeId) {
        return ResponseEntity.ok(respondedApplicantsService.respondedApplicantsListByResume(resumeId));
    }

    @GetMapping("/vacancy/{vacancyId}")
    public ResponseEntity<List<RespondedApplicantsDto>> respondedApplicantsByVacancy(@PathVariable int vacancyId) {
        return ResponseEntity.ok(respondedApplicantsService.respondedApplicantsByVacancy(vacancyId));
    }

}
