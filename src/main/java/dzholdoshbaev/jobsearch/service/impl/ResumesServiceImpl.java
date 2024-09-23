package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dto.ResumeRegisterDto;
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
import java.util.NoSuchElementException;
import java.util.Objects;
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
    private final ContactTypesRepository contactTypesRepository;
    private final UsersRepository usersRepository;

    @Override
    public void createResumes(ResumeRegisterDto resumeRegisterDto) {
        Categories category = categoriesRepository.findById(resumeRegisterDto.getResumes().getCategories().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));
        resumeRegisterDto.getResumes().setCategories(category);
        resumeRegisterDto.getResumes().setCreatedDate(LocalDateTime.now());
        resumeRegisterDto.getResumes().setUpdateTime(LocalDateTime.now());
        Resumes resumes1 = resumesRepository.save(resumeRegisterDto.getResumes());

        for (WorkExperienceInfo workExperienceInfo : resumeRegisterDto.getWorkExperienceInfo()){
            workExperienceInfo.setResumes(resumes1);
            workExperienceInfoRepository.save(workExperienceInfo);
        }

        for (EducationInfo educationInfo : resumeRegisterDto.getEducationInfo()){
            educationInfo.setResumes(resumes1);
            educationInfoRepository.save(educationInfo);
        }


        List<ContactsInfo> list = resumeRegisterDto.getContactsInfoList();
        list.removeIf(Objects::isNull);

        for (ContactsInfo contactsInfo : list) {
            contactsInfo.setResumes(resumes1);
            ContactTypes contactTypes = contactTypesRepository.findById(contactsInfo.getContactTypes().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid contact types ID"));
            contactsInfo.setContactTypes(contactTypes);
            contactsInfoRepository.save(contactsInfo);
        }
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

    @Override
    public List<Resumes> getAllResumesByUser(Long applicantId) {
        var list = resumesRepository.findAllByApplicantId(applicantId);
        log.info("All resumes printed by user");
        return list;
    }

    @Override
    public Resumes getResumeById(Long resumesId) {
        Optional<Resumes> resume = resumesRepository.findById(resumesId);
        log.info("Retrieved resume with id {}", resumesId);
        return resume.orElse(null);
    }

    @Override
    public void editResume(Long resumeId,ResumeRegisterDto resumeRegisterDto) {
        Categories category = categoriesRepository.findById(resumeRegisterDto.getResumes().getCategories().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));
        resumesRepository.updateResumesById(resumeRegisterDto.getResumes().getName(),
                category,
                resumeRegisterDto.getResumes().getSalary(),
                resumeRegisterDto.getResumes().getIsActive(),
                resumeId);
        Resumes resume = resumesRepository.findById(resumeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid resume ID"));

        educationInfoRepository.deleteByResumes_Id(resume.getId());
        workExperienceInfoRepository.deleteByResumes(resume);
        contactsInfoRepository.deleteByResumes(resume);

        for (EducationInfo educationInfo : resumeRegisterDto.getEducationInfo()) {
            educationInfo.setResumes(resume);
            educationInfoRepository.save(educationInfo);
        }

        for (WorkExperienceInfo workExperienceInfo : resumeRegisterDto.getWorkExperienceInfo()) {
            workExperienceInfo.setResumes(resume);
            workExperienceInfoRepository.save(workExperienceInfo);
        }

        for (ContactsInfo contactsInfo : resumeRegisterDto.getContactsInfoList()) {
            ContactTypes contactTypes = contactTypesRepository.findById(contactsInfo.getContactTypes().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid contact types ID"));
            contactsInfo.setContactTypes(contactTypes);
            contactsInfo.setResumes(resume);
            contactsInfoRepository.save(contactsInfo);
        }
        log.info("Edited resume with id {}", resumeId);
    }

    @Override
    public void updateResumeTime(Long resumeId) {
        resumesRepository.updateResumesUpdateTime(resumeId, LocalDateTime.now());
        log.info("Updated resume with id {}", resumeId);
    }
}