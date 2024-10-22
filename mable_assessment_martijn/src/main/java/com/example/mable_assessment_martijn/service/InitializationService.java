package com.example.mable_assessment_martijn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.mable_assessment_martijn.DTO.ArticleDTO;
import com.example.mable_assessment_martijn.DTO.CategoryDTO;
import com.example.mable_assessment_martijn.model.Article;
import com.example.mable_assessment_martijn.model.Category;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.util.Optional;

import org.springframework.core.io.Resource;

@Service
public class InitializationService {
    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ObjectMapper objectMapper;


    //Runs only once upon startup.
    @PostConstruct
    public void initializeArticleDatabase() {

        // Placeholder solution due to not knowing the "easy" to faulty JSON.
        // This file has valid JSON.
        Resource resource = new ClassPathResource("categories.json");
        try {
            CategoryDTO[] categoryDTOs = objectMapper.readValue(resource.getInputStream(), CategoryDTO[].class);
            for (CategoryDTO categoryDTO : categoryDTOs) {
                if (!categoryService.exists(categoryDTO.ID))
                    categoryService.save(new Category(categoryDTO.ID, categoryDTO.Name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArticleDTO[] articleDTOs = restTemplate.getForObject("https://www.mable.consulting/articles.json",
                ArticleDTO[].class);

        for (ArticleDTO articleDTO : articleDTOs) {
            Optional<Category> matchingCategory = categoryService.findCategory(articleDTO.CategoryID);
            // Only insert if the price is less than 100 or discounted to less than 100.
            if (articleDTO.Price < 100 || (articleDTO.Discount == true && articleDTO.DiscountPrice < 100)) {
                if (!articleService.exists(articleDTO.ID))
                    articleService.saveArticle(new Article(articleDTO.ID,
                            matchingCategory.isPresent() ? matchingCategory.get() : null, articleDTO.Name,
                            articleDTO.DateAdded, articleDTO.Price, articleDTO.Discount, articleDTO.DiscountPrice));
            }
        }

    }

}
