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
    @NotBlank(message = "{resumes.createResume.you_have_to_write_company_name}")
    private String companyName;
    @Column(name = "position")
    @NotBlank(message = "{resumes.createResume.you_have_to_write_which_position_you_worked}")
    private String position ;
    @Column(name = "responsibilities")
    @NotBlank(message = "{resumes.createResume.you_have_to_write_your_responsibilities}")
    private String responsibilities;
}
