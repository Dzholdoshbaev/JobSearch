package dzholdoshbaev.jobsearch.controller;

import dzholdoshbaev.jobsearch.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoriesController {

    private final CategoriesService categoriesService;
//
//    @GetMapping
//   public ResponseEntity<List<CategoriesDto>> getCategories() {
//       return new ResponseEntity<>(categoriesService.getCategories(), HttpStatus.OK);
//   }

}
