package dzholdoshbaev.jobsearch.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespondedApplicantsDto {
    private int id;
    @NotNull
    private int resumeId;
    @NotNull
    private int vacancyId;
    private boolean confirmation;
}
