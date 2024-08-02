package dzholdoshbaev.jobsearch.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private int resumeId;
    private int year;
    @NotBlank
    private String companyName;
    @NotBlank
    private String position ;
    private String responsibilities;
}
