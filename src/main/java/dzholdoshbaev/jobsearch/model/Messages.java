package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "responded_applicants_id")
    private RespondedApplicants respondedApplicants;
    @Column(name = "content")
    private String content;
    @Column(name = "timestamp")
    private LocalDateTime timestamp;
}
