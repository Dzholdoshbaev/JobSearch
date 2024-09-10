package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "work_experience_info")
public class WorkExperienceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resumes resumes;
    @Column(name = "years")
    private Long years;
    @Column(name = "company_name")
    @NotBlank(message = "You have to write company name")
    private String companyName;
    @Column(name = "position")
    @NotBlank(message = "You have to write which position you worked")
    private String position ;
    @Column(name = "responsibilities")
    @NotBlank(message = "You have to write your responsibilities")
    private String responsibilities;
}
