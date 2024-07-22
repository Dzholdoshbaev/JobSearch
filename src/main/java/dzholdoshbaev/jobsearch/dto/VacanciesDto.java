package dzholdoshbaev.jobsearch.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class VacanciesDto {
    private int id;
    private String name;
    private String description;
    private int categoryId;
    private double salary;
    private int expFrom;
    private int expTo;
    private boolean isActive;
    private int authorId;
    private LocalDateTime createdDate;
    private LocalDateTime updateTime;
}
