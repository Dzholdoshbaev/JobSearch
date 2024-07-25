package dzholdoshbaev.jobsearch.dto;

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
    private String companyName;
    private String position ;
    private String responsibilities;
}
