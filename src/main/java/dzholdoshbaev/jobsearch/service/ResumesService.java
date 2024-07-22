package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.dto.ResumesDto;

public interface ResumesService {
    void createResumes(ResumesDto resumeDto);

    void editResume(Long resumeId, ResumesDto resumeDto);

    void deleteResume(Long resumeId);
}
