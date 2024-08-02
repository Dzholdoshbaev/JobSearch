package dzholdoshbaev.jobsearch.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EducationInfoDto {
    private int id;
    @NotNull
    private int resumeId;
    @NotBlank
    private String institution;
    @NotBlank
    private String program;
    private LocalDate startDate;
    private LocalDate endDate;
    private String degree;
}
