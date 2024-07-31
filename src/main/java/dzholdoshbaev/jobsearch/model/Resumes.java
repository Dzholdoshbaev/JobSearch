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
public class Resumes {
    private int id;
    private int applicantId;
    private String name;
    private int categoryId;
    private double salary;
    private boolean isActive;
    private LocalDateTime  createdDate;
    private LocalDateTime updateTime;
}
