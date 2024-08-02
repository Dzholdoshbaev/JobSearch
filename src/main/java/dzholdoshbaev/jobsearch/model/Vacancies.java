package dzholdoshbaev.jobsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vacancies {
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
