package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
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
@Table(name = "resumes")
public class Resumes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Users users;
    @Column(name = "name")
    @NotBlank(message = "{resumes.createResume.you_have_to_write_your_profession}")
    private String name;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "{resumes.createResume.you_have_to_choice_category}")
    private Categories categories;
    @Column(name = "salary")
    @NotNull(message = "{resumes.createResume.you_have_to_write_salary}")
    private Double salary;
    @Column(name = "is_active")
    private Boolean  isActive;
    @Column(name = "created_date")
    private LocalDateTime  createdDate;
    @Column(name = "update_time")
    private LocalDateTime updateTime;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "resumes")
    private List<ContactsInfo> contactsInfoList;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "resumes")
    private List<EducationInfo> educationInfoList;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "resumes")
    private List<RespondedApplicants> respondedApplicantsList;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "resumes")
    private List<WorkExperienceInfo> workExperienceInfoList;
}
