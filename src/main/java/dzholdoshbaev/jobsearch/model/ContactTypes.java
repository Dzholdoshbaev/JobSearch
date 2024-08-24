package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "contact_types")
public class ContactTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private String type;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "contactTypes")
    private List<ContactsInfo> contactsInfoList;
}
