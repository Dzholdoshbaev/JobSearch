package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dto.ResumeRegisterDto;
import dzholdoshbaev.jobsearch.model.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Service
public class CheckResumeWithMessage {

    public HashMap<String, String> checkResumeDto(ResumeRegisterDto resumeRegisterDto, Users users) {
        String lang = users.getLocale();
        if (lang == null) {
            lang = Locale.getDefault().getLanguage();
        }
        Locale locale = new Locale(lang);
        ResourceBundle messages = ResourceBundle.getBundle("messages", locale);

        HashMap<String, String> errors = new HashMap<>();


        validateResumes(resumeRegisterDto.getResumes(), errors, messages);


        validateWorkExperienceInfo(resumeRegisterDto.getWorkExperienceInfo(), errors, messages);


        validateEducationInfo(resumeRegisterDto.getEducationInfo(), errors, messages);


        validateContactsInfo(resumeRegisterDto.getContactsInfoList(), errors, messages);

        return errors;
    }

    private void validateResumes(Resumes resumes, HashMap<String, String> errors, ResourceBundle messages) {
        if (resumes == null) {
            errors.put("resumes", messages.getString("resume.complete"));
            return;
        }
        if (resumes.getName() == null || resumes.getName().isEmpty()) {
            errors.put("resumes.name", messages.getString("resume.name"));
        }
        if (resumes.getCategories() == null) {
            errors.put("resumes.categories", messages.getString("resume.categories"));
        }
        if (resumes.getSalary() == null) {
            errors.put("resumes.salary", messages.getString("resume.salary"));
        }
    }

    private void validateWorkExperienceInfo(List<WorkExperienceInfo> workExperienceInfo, HashMap<String, String> errors, ResourceBundle messages) {
        if (workExperienceInfo == null || workExperienceInfo.isEmpty()) {
            errors.put("workExperienceInfo", messages.getString("workExperience.complete"));
            return;
        }
        for (int i = 0; i < workExperienceInfo.size(); i++) {
            WorkExperienceInfo info = workExperienceInfo.get(i);
            if (info.getCompanyName() == null || info.getCompanyName().isEmpty()) {
                errors.put("workExperienceInfo[" + i + "].companyName", messages.getString("workExperience.companyName"));
            }
            if (info.getPosition() == null || info.getPosition().isEmpty()) {
                errors.put("workExperienceInfo[" + i + "].position", messages.getString("workExperience.position"));
            }
            if (info.getResponsibilities() == null || info.getResponsibilities().isEmpty()) {
                errors.put("workExperienceInfo[" + i + "].responsibilities", messages.getString("workExperience.responsibilities"));
            }
        }
    }

    private void validateEducationInfo(List<EducationInfo> educationInfo, HashMap<String, String> errors, ResourceBundle messages) {
        if (educationInfo == null || educationInfo.isEmpty()) {
            errors.put("educationInfo", messages.getString("education.complete"));
            return;
        }
        for (int i = 0; i < educationInfo.size(); i++) {
            EducationInfo info = educationInfo.get(i);
            if (info.getInstitution() == null || info.getInstitution().isEmpty()) {
                errors.put("educationInfo[" + i + "].institution", messages.getString("education.institution"));
            }
            if (info.getProgram() == null || info.getProgram().isEmpty()) {
                errors.put("educationInfo[" + i + "].program", messages.getString("education.program"));
            }
            if (info.getStartDate() == null) {
                errors.put("educationInfo[" + i + "].startDate", messages.getString("education.startDate"));
            }
            if (info.getEndDate() == null) {
                errors.put("educationInfo[" + i + "].endDate", messages.getString("education.endDate"));
            }
            if (info.getDegree() == null || info.getDegree().isEmpty()) {
                errors.put("educationInfo[" + i + "].degree", messages.getString("education.degree"));
            }
        }
    }

    private void validateContactsInfo(List<ContactsInfo> contactsInfoList, HashMap<String, String> errors, ResourceBundle messages) {
        if (contactsInfoList == null || contactsInfoList.isEmpty()) {
            errors.put("contactsInfoList", messages.getString("contacts.complete"));
            return;
        }
        for (int i = 0; i < contactsInfoList.size(); i++) {
            ContactsInfo info = contactsInfoList.get(i);
            if (info.getInfo() == null || info.getInfo().isEmpty()) {
                errors.put("contactsInfoList[" + i + "].info", messages.getString("contacts.info"));
            }
            if (info.getContactTypes() == null) {
                errors.put("contactsInfoList[" + i + "].contactTypes", messages.getString("contacts.type"));
            }
        }
    }
}
