package dzholdoshbaev.jobsearch.dao;

import dzholdoshbaev.jobsearch.model.Messages;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class MessagesDao {
    private List<Messages> messagesList = new ArrayList<>();
}
