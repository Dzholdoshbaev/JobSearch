package dzholdoshbaev.jobsearch.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumesDto {
    private int id;
    @NotBlank
    private int applicantId;
    @NotBlank
    private String name;
    private int categoryId;
    private double salary;
    private boolean isActive;
    private LocalDateTime createdDate;
    private LocalDateTime updateTime;
}
