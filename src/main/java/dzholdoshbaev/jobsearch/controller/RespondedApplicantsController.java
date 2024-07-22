package dzholdoshbaev.jobsearch.controller;


import dzholdoshbaev.jobsearch.dto.RespondedApplicantsDto;
import dzholdoshbaev.jobsearch.service.RespondedApplicantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applicants/responded")
@RequiredArgsConstructor
public class RespondedApplicantsController {
    private final RespondedApplicantsService respondedApplicantsService;

    @PostMapping("/{vacancyId}")
    public ResponseEntity<String> respondToVacancy(@PathVariable Long vacancyId, @RequestBody RespondedApplicantsDto respondedApplicantsDto) {
        return ResponseEntity.ok("Отклик на вакансию отправлен успешно");
    }
}
