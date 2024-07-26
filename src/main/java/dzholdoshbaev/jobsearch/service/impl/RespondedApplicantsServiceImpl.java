package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.RespondedApplicantsDao;
import dzholdoshbaev.jobsearch.dto.RespondedApplicantsDto;
import dzholdoshbaev.jobsearch.model.RespondedApplicants;
import dzholdoshbaev.jobsearch.service.RespondedApplicantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RespondedApplicantsServiceImpl implements RespondedApplicantsService {
    private final RespondedApplicantsDao respondedApplicantsDao;

    @Override
    public void addResponded( RespondedApplicants respondedApplicants) {
        respondedApplicantsDao.addRespondApplicants(respondedApplicants);
    }

    @Override
    public List<RespondedApplicantsDto> getRespondedApplicants() {
        var list = respondedApplicantsDao.getRespondedApplicants();

        return list.stream()
                .map(e -> RespondedApplicantsDto.builder()
                        .id(e.getId())
                        .resumeId(e.getResumeId())
                        .vacancyId(e.getVacancyId())
                        .confirmation(e.isConfirmation())
                        .build()).toList();
    }

    @Override
    public List<RespondedApplicantsDto> respondedApplicantsListByResume(int resumeId){
        var list = respondedApplicantsDao.respondedApplicantsListByResume(resumeId);
        return list.stream()
                .map(e -> RespondedApplicantsDto.builder()
                        .id(e.getId())
                        .resumeId(e.getResumeId())
                        .vacancyId(e.getVacancyId())
                        .confirmation(e.isConfirmation())
                        .build()).toList();
    }

    @Override
    public List<RespondedApplicantsDto> respondedApplicantsByVacancy(int vacancyId){
        var list = respondedApplicantsDao.respondedApplicantsByVacancy(vacancyId);
        return list.stream()
                .map(e -> RespondedApplicantsDto.builder()
                        .id(e.getId())
                        .resumeId(e.getResumeId())
                        .vacancyId(e.getVacancyId())
                        .confirmation(e.isConfirmation())
                        .build()).toList();
    }
}