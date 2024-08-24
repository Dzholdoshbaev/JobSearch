package dzholdoshbaev.jobsearch.service;


import dzholdoshbaev.jobsearch.model.ContactsInfo;
import dzholdoshbaev.jobsearch.model.EducationInfo;
import dzholdoshbaev.jobsearch.model.Resumes;
import dzholdoshbaev.jobsearch.model.WorkExperienceInfo;

import java.util.List;

public interface ResumesService {
    void createResumes(Resumes resumesDto, EducationInfo educationInfoDto, WorkExperienceInfo workExperienceInfoDto, Long userId, ContactsInfo contactsInfoDto);

    void editResume( Resumes resumesDto);

    void deleteResume(Long resumeId);

    List<Resumes> getAllResumes();

    List<Resumes> getAllResumesByCategory(Long categoryId);

    List<Resumes> getAllResumesByUser(Long applicantId);

    Resumes getResumeById(Long resumesId);
}
