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
public class VacanciesDto {
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private int categoryId;
    private double salary;
    private int expFrom;
    private int expTo;
    private boolean isActive;
    @NotNull
    private int authorId;
    private LocalDateTime createdDate;
    private LocalDateTime updateTime;
}
