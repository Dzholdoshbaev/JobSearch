package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.MessagesDao;
import dzholdoshbaev.jobsearch.service.MessagesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@RequiredArgsConstructor
@Service
public class MessagesServiceImpl implements MessagesService {
    private final MessagesDao messagesDao;
}
