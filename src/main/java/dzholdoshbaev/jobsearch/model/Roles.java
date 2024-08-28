package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    private Long id;

    @Column(name = "role")
    private String role;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    private Collection<Authorities> authorities;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id")
    )
    private Collection<Users> users;
}
