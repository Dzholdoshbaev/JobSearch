package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.model.ContactsInfo;
import dzholdoshbaev.jobsearch.model.EducationInfo;
import dzholdoshbaev.jobsearch.model.Resumes;
import dzholdoshbaev.jobsearch.model.WorkExperienceInfo;
import dzholdoshbaev.jobsearch.repository.ResumesRepository;
import dzholdoshbaev.jobsearch.service.ResumesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ResumesServiceImpl implements ResumesService {
    private final ResumesRepository resumesRepository;

    @Override
    public void createResumes(Resumes resumesDto, EducationInfo educationInfoDto, WorkExperienceInfo workExperienceInfoDto, Long userId , ContactsInfo contactsInfoDto) {
        log.info("Created resume with id");
    }

    @Override
    public void editResume(Resumes resumes) {
        log.info("Edited resume with name {}", resumes.getName());
    }

    @Override
    public void deleteResume(Long resumeId) {
        log.info("Deleted resume");
    }

    @Override
    public List<Resumes> getAllResumes() {
        log.info("All resumes printed");
        return resumesRepository.findAll();
    }

    @Override
    public List<Resumes> getAllResumesByCategory(Long categoryId) {
        return List.of();
    }

//    @Override
//    public List<ResumesDto> getAllResumesByCategory(Long categoryId) {
//        var list = resumesDao.getAllResumesByCategory(categoryId);
//
//        List<ResumesDto> sorted = list.stream()
//                .map(e -> ResumesDto.builder()
////                        .id(e.getId())
////                        .applicantId(e.getApplicantId())
//                        .name(e.getName())
////                        .categoryId(e.getCategoryId())
//                        .salary(e.getSalary())
////                        .isActive(e.getIsActive())
//                        .createdDate(e.getCreatedDate())
//                        .updateTime(e.getUpdateTime())
//                        .build()).toList();
//        log.info("All resumes printed by category");
//        return sorted;
//    }

    @Override
    public List<Resumes> getAllResumesByUser(Long applicantId){
        var list = resumesRepository.findAllByApplicantId(applicantId);
        log.info("All resumes printed by user");
        return list;
    }

    @Override
    public Resumes getResumeById(Long resumesId) {
       Optional<Resumes> resume =  resumesRepository.findById(resumesId);
       log.info("Retrieved resume with id {}", resumesId);
       return resume.orElse(null);
    }
}