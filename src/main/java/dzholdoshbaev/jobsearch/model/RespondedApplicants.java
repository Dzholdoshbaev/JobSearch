package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "responded_applicants")
public class RespondedApplicants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resumes resumes;
    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancies vacancies;
    @Column(name = "confirmation")
    private Boolean confirmation;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "respondedApplicants")
    private List<Messages> messagesList;
}
