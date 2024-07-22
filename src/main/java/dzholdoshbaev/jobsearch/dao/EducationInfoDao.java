package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.EducationInfo;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class EducationInfoDao {
    private List<EducationInfo> educationInfoList= new ArrayList<>();
}
