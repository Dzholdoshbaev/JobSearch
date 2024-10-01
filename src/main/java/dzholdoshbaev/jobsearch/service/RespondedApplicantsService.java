package dzholdoshbaev.jobsearch.service;


import dzholdoshbaev.jobsearch.model.RespondedApplicants;
import dzholdoshbaev.jobsearch.model.Resumes;
import dzholdoshbaev.jobsearch.model.Users;

import java.util.List;

public interface RespondedApplicantsService {
    List<RespondedApplicants> getRespondedApplicants();

    List<RespondedApplicants> respondedApplicantsListByResume(Long resumeId);

    List<RespondedApplicants> respondedApplicantsByVacancy(Long vacancyId);

    void addResponded(RespondedApplicants respondedApplicantsDto);

    List<RespondedApplicants> findByUser(Users user);

    void confirmREspond(Users user, Long respondId);

    void createRespond(Long vacanciesId, Resumes resumes, Users user);
}
