package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.dto.ResumesDto;
import dzholdoshbaev.jobsearch.model.EducationInfo;
import dzholdoshbaev.jobsearch.model.Resumes;
import dzholdoshbaev.jobsearch.model.WorkExperienceInfo;

import java.util.List;

public interface ResumesService {
    void createResumes(Resumes resume, EducationInfo educationInfo, WorkExperienceInfo workExperienceInfo);

    void editResume(Long resumeId, ResumesDto resumeDto);

    void deleteResume(Long resumeId);

    List<ResumesDto> getAllResumes();

    List<ResumesDto> getAllResumesByCategory(int categoryId);

    List<ResumesDto> getAllResumesByUser(int applicantId);

    ResumesDto getResumeById(int resumesId);
}
