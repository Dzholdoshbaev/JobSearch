package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contacts_info")
public class ContactsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "info")
    private String info;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resumes resumes;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "type_id")
    private ContactTypes contactTypes;

}
