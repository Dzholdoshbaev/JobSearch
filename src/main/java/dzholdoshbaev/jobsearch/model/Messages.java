package dzholdoshbaev.jobsearch.model;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Messages {
    private int id;
    private int respondedApplicants;
    private String content;
    private LocalDateTime timestamp;
}
