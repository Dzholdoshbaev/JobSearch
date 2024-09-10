package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "should be not blank")
    private String name;
    @Column(name = "description")
    @NotBlank(message = "should be not blank")
    private String description;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "should be not blank")
    private Categories categories;
    @Column(name = "salary")
    @NotNull(message = "should be not blank")
    private Double salary;
    @NotNull(message = "should be not blank")
    @Column(name = "exp_from")
    @Max(value = 80,message = "exp from cannot be longer than 80")
    private Long expFrom;
    @NotNull
    @Column(name = "exp_to")
    @Max(value = 80,message = "exp to cannot be longer than 80" )
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
