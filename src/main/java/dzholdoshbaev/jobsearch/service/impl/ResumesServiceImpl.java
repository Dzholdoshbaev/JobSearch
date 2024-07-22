package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dto.ResumesDto;
import dzholdoshbaev.jobsearch.service.ResumesService;
import org.springframework.stereotype.Service;

@Service
public class ResumesServiceImpl implements ResumesService {
    @Override
    public void createResumes(ResumesDto resumeDto) {
        System.out.println(resumeDto);
    }

    @Override
    public void editResume(Long resumeId, ResumesDto resumeDto) {
        System.out.println(resumeId + " " + resumeDto);
    }

    @Override
    public void deleteResume(Long resumeId) {
        System.out.println(resumeId);
    }
}
