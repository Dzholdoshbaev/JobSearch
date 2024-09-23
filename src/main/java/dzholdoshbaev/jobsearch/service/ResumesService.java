package dzholdoshbaev.jobsearch.service;


import dzholdoshbaev.jobsearch.dto.ResumeRegisterDto;
import dzholdoshbaev.jobsearch.model.Resumes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import java.util.List;

public interface ResumesService {
    void createResumes(ResumeRegisterDto resumeRegisterDto);

    void deleteResume(Long resumeId);

    Page<Resumes> getAllResumes(Pageable pageable);

    List<Resumes> getAllResumesByCategory(Long categoryId);

    List<Resumes> getAllResumesByUser(Long applicantId);

    Resumes getResumeById(Long resumesId);

    void editResume(Long resumeId, ResumeRegisterDto resumeRegisterDto);

    void updateResumeTime(Long resumeId);
}
