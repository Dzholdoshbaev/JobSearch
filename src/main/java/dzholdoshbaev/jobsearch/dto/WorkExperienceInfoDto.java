package dzholdoshbaev.jobsearch.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkExperienceInfoDto {
    private int id;
    private int resumeId;
    private int year;
    @NotBlank(message = "You have to write company name")
    private String companyName;
    @NotBlank(message = "You have to write which position you worked")
    private String position ;
    @NotBlank(message = "You have to write your responsibilities")
    private String responsibilities;
}
