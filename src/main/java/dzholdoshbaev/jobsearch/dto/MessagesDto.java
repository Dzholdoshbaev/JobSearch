package dzholdoshbaev.jobsearch.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class MessagesDto {
    private int id;
    private int respondedApplicants;
    private String content;
    private LocalDateTime timestamp;
}
