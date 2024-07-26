package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.dto.RespondedApplicantsDto;

import java.util.List;

public interface RespondedApplicantsService {
    List<RespondedApplicantsDto> getRespondedApplicants();

    List<RespondedApplicantsDto> respondedApplicantsListByResume(int resumeId);

    List<RespondedApplicantsDto> respondedApplicantsByVacancy(int vacancyId);
}
