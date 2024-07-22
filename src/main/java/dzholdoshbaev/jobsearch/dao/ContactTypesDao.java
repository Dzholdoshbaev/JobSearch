package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.ContactTypes;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class ContactTypesDao {
    private List<ContactTypes> contactTypesList = new ArrayList<>();
}
