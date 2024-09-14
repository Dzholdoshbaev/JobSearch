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
    @NotBlank(message = "{resumes.createResume.you_have_to_write_name_of_institution}")
    private String institution;
    @Column(name = "program")
    @NotBlank(message = "{resumes.createResume.you_have_to_write_which_program}")
    private String program;
    @Column(name = "start_date")
    @NotNull(message = "{resumes.createResume.you_have_to_write_start_date}")
    private LocalDate startDate;
    @Column(name = "end_date")
    @NotNull(message = "{resumes.createResume.you_have_to_write_end_date}")
    private LocalDate endDate;
    @Column(name = "degree")
    @NotBlank(message = "{resumes.createResume.you_have_to_write_your_degree}")
    private String degree;
}
