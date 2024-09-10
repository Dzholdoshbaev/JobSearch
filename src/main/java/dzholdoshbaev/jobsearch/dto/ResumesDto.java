package dzholdoshbaev.jobsearch.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private int applicantId;
    @NotBlank(message = "You have to write your profession")
    private String name;
    @NotNull(message = "You have to choice category")
    private int categoryId;
    @NotNull(message = "You have to write salary")
    private double salary;
    private boolean isActive;
    private LocalDateTime createdDate;
    private LocalDateTime updateTime;
}
