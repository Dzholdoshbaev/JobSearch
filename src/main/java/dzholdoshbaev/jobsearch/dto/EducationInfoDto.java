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
    private int resumeId;
    @NotBlank(message = "You have to write name of institution")
    private String institution;
    @NotBlank(message = "You have to write which program")
    private String program;
    @NotNull(message = "You have to write start date")
    private LocalDate startDate;
    @NotNull(message = "You have to write end date")
    private LocalDate endDate;
    @NotBlank(message = "You have to write your degree")
    private String degree;
}
