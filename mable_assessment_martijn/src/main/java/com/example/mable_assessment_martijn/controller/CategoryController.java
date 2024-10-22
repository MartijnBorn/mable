package com.example.mable_assessment_martijn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.mable_assessment_martijn.model.Category;
import com.example.mable_assessment_martijn.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    //Requirement 1: groepeer artikelen per categorie. 
    @GetMapping("")
    public ResponseEntity<?> getCategories(){
        return new ResponseEntity<>(categoryService.getCategoriesAndArticles(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> updateCategory(@RequestBody Category category){
        //Updating a category that does not exist will instead insert it. Same behavior as post.
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
