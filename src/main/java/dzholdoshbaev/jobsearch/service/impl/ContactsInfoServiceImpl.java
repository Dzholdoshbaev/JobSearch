package dzholdoshbaev.jobsearch.service.impl;

import dzholdoshbaev.jobsearch.model.ContactsInfo;
import dzholdoshbaev.jobsearch.repository.ContactsInfoRepository;
import dzholdoshbaev.jobsearch.service.ContactsInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ContactsInfoServiceImpl implements ContactsInfoService {
    private final ContactsInfoRepository contactsInfoRepository;

    public List<ContactsInfo> findByResumeId(Long resumeId) {
        List<ContactsInfo> contactsInfo = contactsInfoRepository.findByResumes_Id(resumeId);
        log.info("Found contactsInfo: {}", contactsInfo);
        return contactsInfo;
    }
}
