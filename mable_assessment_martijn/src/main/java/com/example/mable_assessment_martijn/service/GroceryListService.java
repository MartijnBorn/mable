package com.example.mable_assessment_martijn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mable_assessment_martijn.model.Article;
import com.example.mable_assessment_martijn.model.GroceryList;
import com.example.mable_assessment_martijn.model.GroceryListRepository;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class GroceryListService {
    @Autowired
    GroceryListRepository groceryListRepository;
    @Autowired
    ArticleService articleService;

    public GroceryList getGroceryList(String name) {
        return groceryListRepository.findByName(name).get(0);
    }

    public GroceryList createAndSaveGroceryList(String name, List<String> articleIds) {
        if (!groceryListRepository.existsByName(name)) {
            ArrayList<Article> articles = new ArrayList<>();
            for (String articleId : articleIds) {
                Optional<Article> article = articleService.findById(articleId);
                if (article.isPresent()) {
                    articles.add(article.get());
                }
            }
            return saveGroceryList(name, articles);
        }
        else{
            return null;
        }
    }

    public GroceryList saveGroceryList(String name, List<Article> articles) {
        return groceryListRepository.save(new GroceryList(name, articles));
    }
}
