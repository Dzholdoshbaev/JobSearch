package dzholdoshbaev.jobsearch.controller;


import dzholdoshbaev.jobsearch.dto.ResumeRegisterDto;
import dzholdoshbaev.jobsearch.model.*;
import dzholdoshbaev.jobsearch.service.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
            @ModelAttribute @Valid ResumeRegisterDto resumeRegisterDto, BindingResult bindingResult,
            Principal principal , Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categoriesDto", categoriesService.getCategories());
            model.addAttribute("contactTypes", contactTypesService.getAllTypes());
            return "resumes/createResume";
        }

        String username = principal.getName();
        Users user = usersService.getUserByEmail(username);
        resumeRegisterDto.getResumes().setUsers(user);

        resumesService.createResumes(resumeRegisterDto);

        return "redirect:/profile";
    }




    @GetMapping("/create")
    public String createResume(Model model, Principal principal) {
        model.addAttribute("categoriesDto", categoriesService.getCategories());
        model.addAttribute("contactTypes", contactTypesService.getAllTypes());
        model.addAttribute("resumeRegisterDto" , new ResumeRegisterDto());
        return "resumes/createResume";
    }

    @GetMapping("/update/{resumeId}")
    public String updateVacancy(@PathVariable Long resumeId){
        resumesService.updateResumeTime(resumeId);
        return "redirect:/profile";
    }


    @PostMapping("/edit/{resumeId}")
    public String editVacancy(@PathVariable Long resumeId,@ModelAttribute @Valid ResumeRegisterDto resumeRegisterDto,
                              BindingResult bindingResult,
                              Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("categoriesDto",categoriesService.getCategories());
            model.addAttribute("contactTypes", contactTypesService.getAllTypes());
            model.addAttribute("resumeId",resumeId);
            return "resumes/editResume";
        }
        resumesService.editResume(resumeId,resumeRegisterDto);
        return "redirect:/profile" ;
    }

    @GetMapping("/edit/{resumeId}")
    public String editVacancy(@PathVariable Long resumeId ,Model model) {
        model.addAttribute("categoriesDto",categoriesService.getCategories());
        model.addAttribute("contactTypes", contactTypesService.getAllTypes());
        model.addAttribute("resumeRegisterDto" , resumesService.getResumeDtoById(resumeId));
        model.addAttribute("resumeId",resumeId);
        return "resumes/editResume";
    }

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

}
