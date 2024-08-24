package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resumes resumes;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private ContactTypes contactTypes;

}
