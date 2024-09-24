package dzholdoshbaev.jobsearch.dto;

import dzholdoshbaev.jobsearch.model.ContactsInfo;
import dzholdoshbaev.jobsearch.model.EducationInfo;
import dzholdoshbaev.jobsearch.model.Resumes;
import dzholdoshbaev.jobsearch.model.WorkExperienceInfo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumeRegisterDto {
    @NotNull(message = "You have to Complete")
    private Resumes resumes;
    @NotNull(message = "You have to Complete")
    private List<WorkExperienceInfo> workExperienceInfo = new ArrayList<>();
    @NotNull(message = "You have to Complete")
    private List<EducationInfo> educationInfo = new ArrayList<>();
    @NotEmpty(message = "Should be not empty")
    private List<ContactsInfo> contactsInfoList;
}
