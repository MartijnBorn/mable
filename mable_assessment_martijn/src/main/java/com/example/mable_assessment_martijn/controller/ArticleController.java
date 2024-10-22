package com.example.mable_assessment_martijn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.mable_assessment_martijn.model.Article;
import com.example.mable_assessment_martijn.service.ArticleService;
import org.springframework.web.bind.annotation.PutMapping;



@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("")
    public ResponseEntity<?> getArticles() {
        return new ResponseEntity<>(articleService.getAllArticles(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> postArticle(@RequestBody Article article){
        return new ResponseEntity<>(articleService.saveArticle(article), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> updateArticle(@RequestBody Article article){
        //Updating an article that does not exist will instead insert it. Same behavior as post.
        return new ResponseEntity<>(articleService.saveArticle(article), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable String id){
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
