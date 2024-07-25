package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.ResumesDao;
import dzholdoshbaev.jobsearch.dto.ResumesDto;
import dzholdoshbaev.jobsearch.service.ResumesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class ResumesServiceImpl implements ResumesService {
    private final ResumesDao resumesDao;

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
