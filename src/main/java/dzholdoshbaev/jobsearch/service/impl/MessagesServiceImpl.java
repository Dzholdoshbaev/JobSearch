package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.MessagesDao;
import dzholdoshbaev.jobsearch.service.MessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class MessagesServiceImpl implements MessagesService {
    private final MessagesDao messagesDao;
}
