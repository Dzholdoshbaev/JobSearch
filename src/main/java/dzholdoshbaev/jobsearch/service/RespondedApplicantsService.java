package dzholdoshbaev.jobsearch.service;


import dzholdoshbaev.jobsearch.model.RespondedApplicants;

import java.util.List;

public interface RespondedApplicantsService {
    List<RespondedApplicants> getRespondedApplicants();

    List<RespondedApplicants> respondedApplicantsListByResume(Long resumeId);

    List<RespondedApplicants> respondedApplicantsByVacancy(Long vacancyId);

    void addResponded(RespondedApplicants respondedApplicantsDto);
}
