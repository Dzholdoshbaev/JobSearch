package dzholdoshbaev.jobsearch.model;

import lombok.Data;

@Data
public class RespondedApplicants {
    private int id;
    private int resumeId;
    private int vacancyId;
    private boolean confirmation;
}
