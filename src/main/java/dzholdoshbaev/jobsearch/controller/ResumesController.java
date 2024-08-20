package dzholdoshbaev.jobsearch.controller;


import dzholdoshbaev.jobsearch.dto.*;

import dzholdoshbaev.jobsearch.service.CategoriesService;
import dzholdoshbaev.jobsearch.service.ContactTypesService;
import dzholdoshbaev.jobsearch.service.ResumesService;
import dzholdoshbaev.jobsearch.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/resumes")
@RequiredArgsConstructor
public class ResumesController {
    @Autowired
    private final ResumesService resumesService;
    private final CategoriesService categoriesService;
    private final ContactTypesService contactTypesService;
    private final UsersService usersService;

    @PostMapping("/create")
    public String createResume(ResumesDto resumesDto , EducationInfoDto educationInfoDto , WorkExperienceInfoDto workExperienceInfoDto, ContactsInfoDto contactsInfoDto, Principal principal, Model model) {
        String username = principal.getName();
        UsersDto user = usersService.getUserByEmail(username);
        resumesService.createResumes(resumesDto,educationInfoDto,workExperienceInfoDto,user.getId() , contactsInfoDto);
        return "redirect:/profile";
    }

    @GetMapping("/create")
    public String createResume(Model model , Principal principal) {
        String username = principal.getName();
        UsersDto user = usersService.getUserByEmail(username);
        model.addAttribute("categoriesDto",categoriesService.getCategories());
        model.addAttribute("contactTypes", contactTypesService.getAllTypes());
        model.addAttribute("userDto", user);
        return "resumes/createResume";
    }

    @PutMapping("/edit")
    public ResponseEntity<String> editResume( ResumesDto resumesDto) {
        resumesService.editResume(resumesDto);
        return ResponseEntity.ok("Резюме успешно отредактировано");
    }

    @DeleteMapping("/delete/{resumeId}")
    public ResponseEntity<String> deleteResume(@PathVariable Long resumeId) {
        resumesService.deleteResume(resumeId);
        return ResponseEntity.ok("Резюме успешно удалено");
    }

    @GetMapping
    public String getAllResumes(Model model) {
        model.addAttribute("resumes", resumesService.getAllResumes());
        return "resumes/resumes";
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ResumesDto>> getAllResumesByCategory(@PathVariable int categoryId) {
        return ResponseEntity.ok(resumesService.getAllResumesByCategory(categoryId));
    }

    @GetMapping("/applicant/{applicantId}")
    public ResponseEntity<List<ResumesDto>> getAllResumesByUser(@PathVariable int applicantId) {
        return ResponseEntity.ok(resumesService.getAllResumesByUser(applicantId));
    }

    @GetMapping("/{resumesId}")
    public ResponseEntity<ResumesDto> getResumesById(@PathVariable int resumesId) {
        return ResponseEntity.ok(resumesService.getResumeById(resumesId));
    }

}
