package dzholdoshbaev.jobsearch.repository;

import dzholdoshbaev.jobsearch.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}
