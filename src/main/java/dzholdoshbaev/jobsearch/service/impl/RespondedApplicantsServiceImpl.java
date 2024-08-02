package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.RespondedApplicantsDao;
import dzholdoshbaev.jobsearch.dto.RespondedApplicantsDto;
import dzholdoshbaev.jobsearch.model.RespondedApplicants;
import dzholdoshbaev.jobsearch.service.RespondedApplicantsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class RespondedApplicantsServiceImpl implements RespondedApplicantsService {
    private final RespondedApplicantsDao respondedApplicantsDao;

    @Override
    public void addResponded( RespondedApplicantsDto respondedApplicantsDto) {
        RespondedApplicants respondedApplicants = RespondedApplicants.builder()
                .id(respondedApplicantsDto.getId())
                .resumeId(respondedApplicantsDto.getResumeId())
                .vacancyId(respondedApplicantsDto.getVacancyId())
                .confirmation(respondedApplicantsDto.isConfirmation())
                .build();
        respondedApplicantsDao.addRespondApplicants(respondedApplicants);
        log.info("Responded applicants added");
    }

    @Override
    public List<RespondedApplicantsDto> getRespondedApplicants() {
        var list = respondedApplicantsDao.getRespondedApplicants();

        List<RespondedApplicantsDto> sorted = list.stream()
                .map(e -> RespondedApplicantsDto.builder()
                        .id(e.getId())
                        .resumeId(e.getResumeId())
                        .vacancyId(e.getVacancyId())
                        .confirmation(e.isConfirmation())
                        .build()).toList();
        log.info("Responded applicants list printed");
        return sorted;
    }

    @Override
    public List<RespondedApplicantsDto> respondedApplicantsListByResume(int resumeId){
        var list = respondedApplicantsDao.respondedApplicantsListByResume(resumeId);
        List<RespondedApplicantsDto> sorted = list.stream()
                .map(e -> RespondedApplicantsDto.builder()
                        .id(e.getId())
                        .resumeId(e.getResumeId())
                        .vacancyId(e.getVacancyId())
                        .confirmation(e.isConfirmation())
                        .build()).toList();
        log.info("Responded applicants list printed by resume");
        return sorted;
    }

    @Override
    public List<RespondedApplicantsDto> respondedApplicantsByVacancy(int vacancyId){
        var list = respondedApplicantsDao.respondedApplicantsByVacancy(vacancyId);
        List<RespondedApplicantsDto> sorted = list.stream()
                .map(e -> RespondedApplicantsDto.builder()
                        .id(e.getId())
                        .resumeId(e.getResumeId())
                        .vacancyId(e.getVacancyId())
                        .confirmation(e.isConfirmation())
                        .build()).toList();
        log.info("Responded applicants list printed by vacancy");
        return sorted;
    }
}