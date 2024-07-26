package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.ResumesDao;
import dzholdoshbaev.jobsearch.dto.ResumesDto;
import dzholdoshbaev.jobsearch.model.Resumes;
import dzholdoshbaev.jobsearch.service.ResumesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ResumesServiceImpl implements ResumesService {
    private final ResumesDao resumesDao;

    @Override
    public void createResumes(Resumes resume) {
        resumesDao.addResume(resume);
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

        return list.stream()
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
    }

    @Override
    public List<ResumesDto> getAllResumesByCategory(int categoryId) {
        var list = resumesDao.getAllResumesByCategory(categoryId);

        return list.stream()
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
    }

    @Override
    public List<ResumesDto> getAllResumesByUser(int applicantId){
        var list = resumesDao.getAllResumesByUser(applicantId);

        return list.stream()
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
    }
}