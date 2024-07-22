package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.Resumes;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class ResumesDao {
    private List<Resumes> resumesList = new ArrayList<>();
}
