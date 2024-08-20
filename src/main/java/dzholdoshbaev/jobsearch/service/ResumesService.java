package dzholdoshbaev.jobsearch.service;

import dzholdoshbaev.jobsearch.dto.ContactsInfoDto;
import dzholdoshbaev.jobsearch.dto.EducationInfoDto;
import dzholdoshbaev.jobsearch.dto.ResumesDto;
import dzholdoshbaev.jobsearch.dto.WorkExperienceInfoDto;
import java.util.List;

public interface ResumesService {
    void createResumes(ResumesDto resumesDto, EducationInfoDto educationInfoDto, WorkExperienceInfoDto workExperienceInfoDto, int userId, ContactsInfoDto contactsInfoDto);

    void editResume( ResumesDto resumesDto);

    void deleteResume(Long resumeId);

    List<ResumesDto> getAllResumes();

    List<ResumesDto> getAllResumesByCategory(int categoryId);

    List<ResumesDto> getAllResumesByUser(int applicantId);

    ResumesDto getResumeById(int resumesId);
}
