package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.ContactsInfoDao;
import dzholdoshbaev.jobsearch.service.ContactsInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@RequiredArgsConstructor
@Service
public class ContactsInfoServiceImpl implements ContactsInfoService {
    private final ContactsInfoDao contactsInfoDao;
}
