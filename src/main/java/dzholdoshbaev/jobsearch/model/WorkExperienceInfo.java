package dzholdoshbaev.jobsearch.model;

import lombok.Data;

@Data
public class WorkExperienceInfo {
    private int id;
    private int resumeId;
    private int year;
    private String companyName;
    private String position ;
    private String responsibilities;
}
