package dzholdoshbaev.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EducationInfo {
    private int id;
    private int resumeId;
    private String institution;
    private String program;
    private LocalDate startDate;
    private LocalDate endDate;
    private String degree;
}
