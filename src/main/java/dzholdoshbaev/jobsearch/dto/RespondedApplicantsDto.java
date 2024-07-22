package dzholdoshbaev.jobsearch.dto;

import lombok.Data;

@Data
public class RespondedApplicantsDto {
    private int id;
    private int resumeId;
    private int vacancyId;
    private boolean confirmation;
}
