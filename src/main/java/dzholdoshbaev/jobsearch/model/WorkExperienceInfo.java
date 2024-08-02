package dzholdoshbaev.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkExperienceInfo {
    private int id;
    private int resumeId;
    private int year;
    private String companyName;
    private String position ;
    private String responsibilities;
}
