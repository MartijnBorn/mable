package com.example.mable_assessment_martijn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mable_assessment_martijn.model.Article;
import com.example.mable_assessment_martijn.model.ArticleRepository;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }

    public Article saveArticle(Article article){
        return articleRepository.save(article);
    }
    public Optional<Article> findById(String id){
        return articleRepository.findById(id);
    }

    public void deleteArticle(String id){
        articleRepository.deleteById(id);
    }
    public boolean exists(String id){
        return articleRepository.existsById(id);
    }

}
