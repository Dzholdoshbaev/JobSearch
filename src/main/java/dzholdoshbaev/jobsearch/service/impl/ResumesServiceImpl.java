package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.ResumesDao;
import dzholdoshbaev.jobsearch.dto.ResumesDto;
import dzholdoshbaev.jobsearch.model.EducationInfo;
import dzholdoshbaev.jobsearch.model.Resumes;
import dzholdoshbaev.jobsearch.model.WorkExperienceInfo;
import dzholdoshbaev.jobsearch.service.ResumesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class ResumesServiceImpl implements ResumesService {
    private final ResumesDao resumesDao;

    @Override
    public void createResumes(Resumes resume, EducationInfo educationInfo, WorkExperienceInfo workExperienceInfo) {
        resumesDao.addResume(resume , educationInfo , workExperienceInfo);
        log.info("Created resume with id");
    }

    @Override
    public void editResume(Long resumeId, ResumesDto resumeDto) {
        System.out.println(resumeId + " " + resumeDto);
    }

    @Override
    public void deleteResume(Long resumeId) {
        System.out.println(resumeId);
    }

    @Override
    public List<ResumesDto> getAllResumes() {
        var list = resumesDao.getAllResumes();

        List<ResumesDto> sorted = list.stream()
                .map(e -> ResumesDto.builder()
                        .id(e.getId())
                        .applicantId(e.getApplicantId())
                        .name(e.getName())
                        .categoryId(e.getCategoryId())
                        .salary(e.getSalary())
                        .isActive(e.isActive())
                        .createdDate(e.getCreatedDate())
                        .updateTime(e.getUpdateTime())
                        .build()).toList();
        log.info("All resumes printed");
        return sorted;
    }

    @Override
    public List<ResumesDto> getAllResumesByCategory(int categoryId) {
        var list = resumesDao.getAllResumesByCategory(categoryId);

        List<ResumesDto> sorted = list.stream()
                .map(e -> ResumesDto.builder()
                        .id(e.getId())
                        .applicantId(e.getApplicantId())
                        .name(e.getName())
                        .categoryId(e.getCategoryId())
                        .salary(e.getSalary())
                        .isActive(e.isActive())
                        .createdDate(e.getCreatedDate())
                        .updateTime(e.getUpdateTime())
                        .build()).toList();
        log.info("All resumes printed by category");
        return sorted;
    }

    @Override
    public List<ResumesDto> getAllResumesByUser(int applicantId){
        var list = resumesDao.getAllResumesByUser(applicantId);

        List<ResumesDto> sorted = list.stream()
                .map(e -> ResumesDto.builder()
                        .id(e.getId())
                        .applicantId(e.getApplicantId())
                        .name(e.getName())
                        .categoryId(e.getCategoryId())
                        .salary(e.getSalary())
                        .isActive(e.isActive())
                        .createdDate(e.getCreatedDate())
                        .updateTime(e.getUpdateTime())
                        .build()).toList();
        log.info("All resumes printed by user");
        return sorted;
    }

    @Override
    public ResumesDto getResumeById(int resumesId) {
        var object = resumesDao.getResumeById(resumesId)
                .orElseThrow(() -> new RuntimeException("resume not found"));
        ResumesDto corrected = ResumesDto.builder()
                .id(object.getId())
                .applicantId(object.getApplicantId())
                .name(object.getName())
                .categoryId(object.getCategoryId())
                .salary(object.getSalary())
                .isActive(object.isActive())
                .createdDate(object.getCreatedDate())
                .updateTime(object.getUpdateTime())
                .build();
        log.info("resume printed");
        return corrected;
    }
}