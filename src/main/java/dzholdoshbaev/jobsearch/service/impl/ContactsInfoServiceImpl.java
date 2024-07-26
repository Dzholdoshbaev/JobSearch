package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.dao.ContactsInfoDao;
import dzholdoshbaev.jobsearch.service.ContactsInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class ContactsInfoServiceImpl implements ContactsInfoService {
    private final ContactsInfoDao contactsInfoDao;
}
