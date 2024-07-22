package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.RespondedApplicants;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class RespondedApplicantsDao {
    private List<RespondedApplicants> respondedApplicantsList= new ArrayList<>();
}
