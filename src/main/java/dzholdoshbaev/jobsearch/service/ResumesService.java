package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.dto.ResumesDto;

import java.util.List;

public interface ResumesService {
    void createResumes(ResumesDto resumeDto);

    void editResume(Long resumeId, ResumesDto resumeDto);

    void deleteResume(Long resumeId);

    List<ResumesDto> getAllResumes();

    List<ResumesDto> getAllResumesByCategory(int categoryId);

    List<ResumesDto> getAllResumesByUser(int applicantId);
}
