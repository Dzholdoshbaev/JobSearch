package dzholdoshbaev.jobsearch.service.impl;


import dzholdoshbaev.jobsearch.model.RespondedApplicants;
import dzholdoshbaev.jobsearch.model.Resumes;
import dzholdoshbaev.jobsearch.model.Users;
import dzholdoshbaev.jobsearch.model.Vacancies;
import dzholdoshbaev.jobsearch.repository.RespondedApplicantsRepository;
import dzholdoshbaev.jobsearch.repository.ResumesRepository;
import dzholdoshbaev.jobsearch.repository.VacanciesRepository;
import dzholdoshbaev.jobsearch.service.RespondedApplicantsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class RespondedApplicantsServiceImpl implements RespondedApplicantsService {
    private final RespondedApplicantsRepository respondedApplicantsRepository;
    private final ResumesRepository resumesRepository;
    private final VacanciesRepository vacanciesRepository;



    @Override
    public void addResponded( RespondedApplicants respondedApplicantsDto) {
        log.info("Responded applicants added");
    }

    @Override
    public List<RespondedApplicants> findByUser(Users user) {
       if (user.getAuthorities().toString().equalsIgnoreCase("APPLICANT")){
           List<Resumes> resumes = resumesRepository.findAllByApplicantId(user.getId());
           List<RespondedApplicants> respondedApplicants = respondedApplicantsRepository.findAll();
           List<RespondedApplicants> userList = new ArrayList<>();
           for (RespondedApplicants respondedApplicant: respondedApplicants) {
               for (Resumes resume : resumes) {
                   if(resume.equals(respondedApplicant.getResumes())){
                       userList.add(respondedApplicant);
                   }
               }
           }
           return userList;
       }else {
           List<Vacancies> vacancies = vacanciesRepository.findAllByApplicantId(user.getId());
           List<RespondedApplicants> respondedApplicants = respondedApplicantsRepository.findAll();
           List<RespondedApplicants> userList = new ArrayList<>();
           for (RespondedApplicants respondedApplicant: respondedApplicants) {
               for (Vacancies vacancy : vacancies) {
                   if(vacancy.equals(respondedApplicant.getVacancies())){
                       userList.add(respondedApplicant);
                   }
               }
           }
           return userList;
       }
    }

    @Override
    public void confirmREspond(Users user, Long respondId) {
        Optional<RespondedApplicants> respondedApplicants = respondedApplicantsRepository.findById(respondId);
        if (respondedApplicants.isPresent()) {
           if (respondedApplicants.get().getVacancies().getUsers().equals(user)){
               respondedApplicants.get().setConfirmation(true);
               respondedApplicantsRepository.save(respondedApplicants.get());
           }
        }else {
            throw new IllegalArgumentException("Invalid responded applicant");
        }
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