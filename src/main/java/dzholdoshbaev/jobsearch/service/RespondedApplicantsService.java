package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.dto.RespondedApplicantsDto;
import dzholdoshbaev.jobsearch.model.RespondedApplicants;

import java.util.List;

public interface RespondedApplicantsService {
    List<RespondedApplicantsDto> getRespondedApplicants();

    List<RespondedApplicantsDto> respondedApplicantsListByResume(int resumeId);

    List<RespondedApplicantsDto> respondedApplicantsByVacancy(int vacancyId);

    void addResponded(RespondedApplicantsDto respondedApplicantsDto);
}
