package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Users users;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;
    @Column(name = "salary")
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
