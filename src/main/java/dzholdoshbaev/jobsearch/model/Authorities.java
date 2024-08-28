package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "authorities")
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "authority")
    private String authority;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "roles_authorities",
            joinColumns = @JoinColumn(name = "authority_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Roles> roles;


}
