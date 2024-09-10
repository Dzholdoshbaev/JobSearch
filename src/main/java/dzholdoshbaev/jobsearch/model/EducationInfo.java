package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "education_info")
public class EducationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resumes resumes;
    @Column(name = "institution")
    @NotBlank(message = "You have to write name of institution")
    private String institution;
    @Column(name = "program")
    @NotBlank(message = "You have to write which program")
    private String program;
    @Column(name = "start_date")
    @NotNull(message = "You have to write start date")
    private LocalDate startDate;
    @Column(name = "end_date")
    @NotNull(message = "You have to write end date")
    private LocalDate endDate;
    @Column(name = "degree")
    @NotBlank(message = "You have to write your degree")
    private String degree;
}
