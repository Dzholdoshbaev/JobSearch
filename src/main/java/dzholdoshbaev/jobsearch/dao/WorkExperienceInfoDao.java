package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.WorkExperienceInfo;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class WorkExperienceInfoDao {
    private List<WorkExperienceInfo> workExperienceInfoList = new ArrayList<>();
}
