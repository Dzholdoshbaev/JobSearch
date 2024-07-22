package dzholdoshbaev.jobsearch.dto;

import lombok.Data;

@Data
public class WorkExperienceInfoDto {
    private int id;
    private int resumeId;
    private int year;
    private String companyName;
    private String position ;
    private String responsibilities;
}
