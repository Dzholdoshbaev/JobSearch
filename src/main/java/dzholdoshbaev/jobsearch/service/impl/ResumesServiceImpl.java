package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.model.*;
import dzholdoshbaev.jobsearch.repository.*;
import dzholdoshbaev.jobsearch.service.ResumesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ResumesServiceImpl implements ResumesService {
    private final ResumesRepository resumesRepository;
    private final EducationInfoRepository educationInfoRepository;
    private final WorkExperienceInfoRepository workExperienceInfoRepository;
    private final ContactsInfoRepository contactsInfoRepository;
    private final CategoriesRepository categoriesRepository;
    private final ContactTypesRepository  contactTypesRepository;
    private final UsersRepository      usersRepository;

    @Override
    public void createResumes(Resumes resumes, EducationInfo educationInfo, WorkExperienceInfo workExperienceInfo,  ContactsInfo contactsInfo) {
        Categories category = categoriesRepository.findById(resumes.getCategories().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));
        resumes.setCategories(category);
        resumes.setCreatedDate(LocalDateTime.now());
        resumes.setUpdateTime(LocalDateTime.now());
        Resumes resumes1 = resumesRepository.save(resumes);

        workExperienceInfo.setResumes(resumes1);
        workExperienceInfoRepository.save(workExperienceInfo);

        educationInfo.setResumes(resumes1);
        educationInfoRepository.save(educationInfo);

        contactsInfo.setResumes(resumes1);
        ContactTypes contactTypes = contactTypesRepository.findById(contactsInfo.getContactTypes().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact types ID"));
        contactsInfo.setContactTypes(contactTypes);
        contactsInfoRepository.save(contactsInfo);

        log.info("Created resume with id");
    }

    @Override
    public void deleteResume(Long resumeId) {
        log.info("Deleted resume");
    }

    @Override
    public Page<Resumes> getAllResumes(Pageable pageable) {
        Page<Resumes> resumesPage = resumesRepository.findAll(pageable);
        List<Resumes> resumesList = resumesPage.getContent();
        return new PageImpl<>(resumesList, pageable, resumesPage.getTotalElements());
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

    @Override
    public void editResume(Long resumeId, Resumes resumes, EducationInfo educationInfo, WorkExperienceInfo workExperienceInfo, ContactsInfo contactsInfo) {
        Categories category = categoriesRepository.findById(resumes.getCategories().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));
       resumesRepository.updateResumesById(resumes.getName(),
               category,
               resumes.getSalary(),
               resumes.getIsActive(),
               resumeId);
       Resumes resume = resumesRepository.findById(resumeId)
               .orElseThrow(() -> new IllegalArgumentException("Invalid resume ID"));

       educationInfoRepository.updateEducationInfoByResumes_Id(educationInfo.getInstitution(),
               educationInfo.getProgram(),
               educationInfo.getStartDate(),
               educationInfo.getEndDate(),
               educationInfo.getDegree(),
               resume);
        workExperienceInfoRepository.updateWorkExperienceInfoByResumeId(workExperienceInfo.getCompanyName(),
                workExperienceInfo.getPosition(),
                workExperienceInfo.getYears(),
                workExperienceInfo.getResponsibilities(),
                resume);

        ContactTypes contactTypes = contactTypesRepository.findById(contactsInfo.getContactTypes().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact types ID"));

        contactsInfoRepository.updateEducationInfoByResumes_Id(contactTypes,contactsInfo.getInfo(),resume);

        log.info("Edited resume with id {}", resumeId);

    }

    @Override
    public void updateResumeTime(Long resumeId) {
        resumesRepository.updateResumesUpdateTime(resumeId, LocalDateTime.now());
        log.info("Updated resume with id {}", resumeId);
    }
}