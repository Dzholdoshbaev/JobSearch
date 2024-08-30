package dzholdoshbaev.jobsearch.controller;


import dzholdoshbaev.jobsearch.model.*;
import dzholdoshbaev.jobsearch.service.*;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;



import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/resumes")
@RequiredArgsConstructor
public class ResumesController {
    @Autowired
    private final ResumesService resumesService;
    private final CategoriesService categoriesService;
    private final ContactTypesService contactTypesService;
    private final UsersService usersService;
    private final WorkExperienceInfoService workExperienceInfoService;
    private final EducationInfoService educationInfoService;
    private final ContactsInfoService contactsInfoService;

    @PostMapping("/create")
    public String createResume(
            @ModelAttribute Resumes resumes,
            @ModelAttribute EducationInfo educationInfo,
            @ModelAttribute WorkExperienceInfo workExperienceInfo,
            @ModelAttribute ContactsInfo contactsInfo,
            Principal principal) {

        String username = principal.getName();
        Users user = usersService.getUserByEmail(username);
        resumes.setUsers(user);

        resumesService.createResumes(resumes, educationInfo, workExperienceInfo, contactsInfo);

        return "redirect:/profile";
    }



    @GetMapping("/create")
    public String createResume(Model model, Principal principal) {
        model.addAttribute("categoriesDto", categoriesService.getCategories());
        model.addAttribute("contactTypes", contactTypesService.getAllTypes());
        return "resumes/createResume";
    }

    @GetMapping("/update/{resumeId}")
    public String updateVacancy(@PathVariable Long resumeId){
        resumesService.updateResumeTime(resumeId);
        return "redirect:/profile";
    }


    @PostMapping("/edit/{resumeId}")
    public String editVacancy(@PathVariable Long resumeId,
                              @ModelAttribute Resumes resumes,
                              @ModelAttribute EducationInfo educationInfo,
                              @ModelAttribute WorkExperienceInfo workExperienceInfo,
                              @ModelAttribute ContactsInfo contactsInfo) {
        resumesService.editResume(resumeId,resumes,educationInfo,workExperienceInfo,contactsInfo);
        return "redirect:/profile" ;
    }

    @GetMapping("/edit/{resumeId}")
    public String editVacancy(@PathVariable Long resumeId ,Model model) {
        model.addAttribute("categoriesDto",categoriesService.getCategories());
        model.addAttribute("contactTypes", contactTypesService.getAllTypes());
        model.addAttribute("resumeId",resumeId);
        return "resumes/editResume";
    }

//    @PutMapping("/edit")
//    public ResponseEntity<String> editResume( ResumesDto resumesDto) {
//        resumesService.editResume(resumesDto);
//        return ResponseEntity.ok("Резюме успешно отредактировано");
//    }
//
//    @DeleteMapping("/delete/{resumeId}")
//    public ResponseEntity<String> deleteResume(@PathVariable Long resumeId) {
//        resumesService.deleteResume(resumeId);
//        return ResponseEntity.ok("Резюме успешно удалено");
//    }

    @GetMapping
    public String getAllResumes(Model model, @PageableDefault(size = 3, sort = "createdDate") Pageable pageable) {
        model.addAttribute("resumes", resumesService.getAllResumes(pageable));
        return "resumes/resumes";
    }

    @GetMapping("/{resumeId}")
    public String getResumeById(@PathVariable Long resumeId, Model model) {

        Resumes resume = resumesService.getResumeById(resumeId);
        if (resume == null) {
            throw new NoSuchElementException("no such resume found");
        }
        WorkExperienceInfo workExperienceInfo = workExperienceInfoService.getByResumeId(resumeId);

        EducationInfo educationInfo = educationInfoService.findByResumeId(resumeId);

        List<ContactsInfo> contactsInfoList = contactsInfoService.findByResumeId(resumeId);

        model.addAttribute("workExperienceInfo", workExperienceInfo);
        model.addAttribute("educationInfo", educationInfo);
        model.addAttribute("contactsInfoList", contactsInfoList);
        model.addAttribute("resume", resume);
        return "resumes/resume";
    }

//    @GetMapping("/category/{categoryId}")
//    public ResponseEntity<List<ResumesDto>> getAllResumesByCategory(@PathVariable int categoryId) {
//        return ResponseEntity.ok(resumesService.getAllResumesByCategory(categoryId));
//    }
//
//    @GetMapping("/applicant/{applicantId}")
//    public ResponseEntity<List<ResumesDto>> getAllResumesByUser(@PathVariable int applicantId) {
//        return ResponseEntity.ok(resumesService.getAllResumesByUser(applicantId));
//    }
//
//    @GetMapping("/{resumesId}")
//    public ResponseEntity<ResumesDto> getResumesById(@PathVariable int resumesId) {
//        return ResponseEntity.ok(resumesService.getResumeById(resumesId));
//    }

}
