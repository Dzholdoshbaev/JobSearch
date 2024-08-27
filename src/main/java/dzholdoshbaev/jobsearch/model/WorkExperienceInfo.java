package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
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
    private String companyName;
    @Column(name = "position")
    private String position ;
    @Column(name = "responsibilities")
    private String responsibilities;
}
