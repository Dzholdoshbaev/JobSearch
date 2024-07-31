package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.ResumesDao;
import dzholdoshbaev.jobsearch.dto.EducationInfoDto;
import dzholdoshbaev.jobsearch.dto.ResumesDto;
import dzholdoshbaev.jobsearch.dto.WorkExperienceInfoDto;
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
    public void createResumes(ResumesDto resumesDto, EducationInfoDto educationInfoDto, WorkExperienceInfoDto workExperienceInfoDto) {

        Resumes resumes = Resumes.builder()
                .id(resumesDto.getId())
                .applicantId(resumesDto.getApplicantId())
                .name(resumesDto.getName())
                .categoryId(resumesDto.getCategoryId())
                .salary(resumesDto.getSalary())
                .isActive(resumesDto.isActive())
                .createdDate(resumesDto.getCreatedDate())
                .updateTime(resumesDto.getUpdateTime())
                .build();

        EducationInfo educationInfo = EducationInfo.builder()
                .id(educationInfoDto.getId())
                .resumeId(educationInfoDto.getResumeId())
                .institution(educationInfoDto.getInstitution())
                .program(educationInfoDto.getProgram())
                .startDate(educationInfoDto.getStartDate())
                .endDate(educationInfoDto.getEndDate())
                .degree(educationInfoDto.getDegree())
                .build();

        WorkExperienceInfo workExperienceInfo = WorkExperienceInfo.builder()
                .id(workExperienceInfoDto.getId())
                .resumeId(workExperienceInfoDto.getResumeId())
                .year(workExperienceInfoDto.getYear())
                .companyName(workExperienceInfoDto.getCompanyName())
                .position(workExperienceInfoDto.getPosition())
                .responsibilities(workExperienceInfoDto.getResponsibilities())
                .build();

        resumesDao.addResume(resumes , educationInfo , workExperienceInfo);
        log.info("Created resume with id");
    }

    @Override
    public void editResume(ResumesDto resumesDto) {

        Resumes resumes = Resumes.builder()
                .id(resumesDto.getId())
                .applicantId(resumesDto.getApplicantId())
                .name(resumesDto.getName())
                .categoryId(resumesDto.getCategoryId())
                .salary(resumesDto.getSalary())
                .isActive(resumesDto.isActive())
                .createdDate(resumesDto.getCreatedDate())
                .updateTime(resumesDto.getUpdateTime())
                .build();

        resumesDao.editResume(resumes);
        log.info("Edited resume with name {}", resumes.getName());
    }

    @Override
    public void deleteResume(Long resumeId) {
        resumesDao.deleteResume(resumeId);
        log.info("Deleted resume");
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