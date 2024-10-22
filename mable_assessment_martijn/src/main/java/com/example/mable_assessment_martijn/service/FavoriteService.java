package com.example.mable_assessment_martijn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.mable_assessment_martijn.model.FavoriteRepository;
import com.example.mable_assessment_martijn.model.Article;
import com.example.mable_assessment_martijn.model.Favorite;
import java.util.stream.Collectors;
@Service
public class FavoriteService {
    @Autowired
    FavoriteRepository favoriteRepository;
    @Autowired
    ArticleService articleService;
    public List<Article> getFavorites(){
        List<Favorite> favorites = favoriteRepository.findAll();
        List<Article> articleList = favorites.stream().map(Favorite::getArticle).collect(Collectors.toList());
        return articleList;
    }

    public void addFavorite(String id){
        Optional<Article> article = articleService.findById(id);
        if(article.isPresent()){
            Favorite favorite = new Favorite(article.get());
            favoriteRepository.save(favorite);
        }
        
    }
}
