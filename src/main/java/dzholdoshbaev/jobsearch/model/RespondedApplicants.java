package dzholdoshbaev.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RespondedApplicants {
    private int id;
    private int resumeId;
    private int vacancyId;
    private boolean confirmation;
}
