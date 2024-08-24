package dzholdoshbaev.jobsearch.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Categories categories;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "categories")
    private List<Categories> categoriesList;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "categories")
    private List<Resumes> resumesList;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "categories")
    private List<Vacancies> vacanciesList;
}
