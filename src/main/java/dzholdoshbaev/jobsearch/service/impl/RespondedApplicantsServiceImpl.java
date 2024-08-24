package dzholdoshbaev.jobsearch.service.impl;


import dzholdoshbaev.jobsearch.model.RespondedApplicants;
import dzholdoshbaev.jobsearch.repository.RespondedApplicantsRepository;
import dzholdoshbaev.jobsearch.service.RespondedApplicantsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class RespondedApplicantsServiceImpl implements RespondedApplicantsService {
    RespondedApplicantsRepository respondedApplicantsRepository;

    @Override
    public void addResponded( RespondedApplicants respondedApplicantsDto) {
        log.info("Responded applicants added");
    }

    @Override
    public List<RespondedApplicants> getRespondedApplicants() {
        log.info("Responded applicants list printed");
        return respondedApplicantsRepository.findAll();
    }

    @Override
    public List<RespondedApplicants> respondedApplicantsListByResume(Long resumeId) {
        return List.of();
    }

    @Override
    public List<RespondedApplicants> respondedApplicantsByVacancy(Long vacancyId) {
        return List.of();
    }
}