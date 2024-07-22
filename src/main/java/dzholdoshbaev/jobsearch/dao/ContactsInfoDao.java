package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.ContactsInfo;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class ContactsInfoDao {
    private List<ContactsInfo> contactsInfoList  = new ArrayList<>();
}
