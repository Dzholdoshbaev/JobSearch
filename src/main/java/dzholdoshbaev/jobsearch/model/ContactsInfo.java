package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "{resumes.createResume.you_have_to_write_your_information}")
    private String info;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resumes resumes;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "type_id")
    @NotNull(message = "{resumes.createResume.you_have_to_choice_contacts_type}")
    private ContactTypes contactTypes;

}
