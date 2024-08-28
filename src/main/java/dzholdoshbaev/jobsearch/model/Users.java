package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private Long age;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "enabled")
    private Boolean enabled;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<Resumes> resumesList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<Vacancies> vacanciesList;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
    private Collection<Roles> roles;

}
