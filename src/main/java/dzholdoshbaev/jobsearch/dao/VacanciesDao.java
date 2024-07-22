package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.Vacancies;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class VacanciesDao {
    private List<Vacancies> vacanciesList = new ArrayList<>();
}
