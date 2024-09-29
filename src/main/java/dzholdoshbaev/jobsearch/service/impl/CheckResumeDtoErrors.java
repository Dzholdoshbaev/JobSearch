package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dto.ResumeRegisterDto;
import dzholdoshbaev.jobsearch.model.ContactsInfo;
import dzholdoshbaev.jobsearch.model.EducationInfo;
import dzholdoshbaev.jobsearch.model.Resumes;
import dzholdoshbaev.jobsearch.model.WorkExperienceInfo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CheckResumeDtoErrors {

    public boolean checkResumeErrors(ResumeRegisterDto resumeRegisterDto) {

        if (hasResumesErrors(resumeRegisterDto.getResumes())) {
            return true;
        }


        if (hasWorkExperienceInfoErrors(resumeRegisterDto.getWorkExperienceInfo())) {
            return true;
        }


        if (hasEducationInfoErrors(resumeRegisterDto.getEducationInfo())) {
            return true;
        }


        if (hasContactsInfoErrors(resumeRegisterDto.getContactsInfoList())) {
            return true;
        }

        return false;
    }

    private boolean hasResumesErrors(Resumes resumes) {
        if (resumes == null) {
            return true;
        }
        if (resumes.getName() == null || resumes.getName().isEmpty()) {
            return true;
        }
        if (resumes.getCategories() == null) {
            return true;
        }
        if (resumes.getSalary() == null) {
            return true;
        }
        return false;
    }

    private boolean hasWorkExperienceInfoErrors(List<WorkExperienceInfo> workExperienceInfo) {
        if (workExperienceInfo == null || workExperienceInfo.isEmpty()) {
            return true;
        }
        for (WorkExperienceInfo info : workExperienceInfo) {
            if (info.getCompanyName() == null || info.getCompanyName().isEmpty()) {
                return true;
            }
            if (info.getPosition() == null || info.getPosition().isEmpty()) {
                return true;
            }
            if (info.getResponsibilities() == null || info.getResponsibilities().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private boolean hasEducationInfoErrors(List<EducationInfo> educationInfo) {
        if (educationInfo == null || educationInfo.isEmpty()) {
            return true;
        }
        for (EducationInfo info : educationInfo) {
            if (info.getInstitution() == null || info.getInstitution().isEmpty()) {
                return true;
            }
            if (info.getProgram() == null || info.getProgram().isEmpty()) {
                return true;
            }
            if (info.getStartDate() == null) {
                return true;
            }
            if (info.getEndDate() == null) {
                return true;
            }
            if (info.getStartDate().isAfter(info.getEndDate())) {
                return true;
            }
            if (info.getDegree() == null || info.getDegree().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private boolean hasContactsInfoErrors(List<ContactsInfo> contactsInfoList) {
        if (contactsInfoList == null || contactsInfoList.isEmpty()) {
            return true;
        }
        for (ContactsInfo info : contactsInfoList) {
            if (info.getInfo() == null || info.getInfo().isEmpty()) {
                return true;
            }
            if (info.getContactTypes() == null) {
                return true;
            }
        }
        return false;
    }

}
