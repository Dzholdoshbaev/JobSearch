package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "vacancies")
public class Vacancies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "exp_from")
    private Long expFrom;
    @Column(name = "exp_to")
    private Long expTo;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "respond_amount")
    private Long respondAmount;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Users users;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "update_time")
    private LocalDateTime updateTime;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "vacancies")
    List<RespondedApplicants> respondedApplicantsList;
}
