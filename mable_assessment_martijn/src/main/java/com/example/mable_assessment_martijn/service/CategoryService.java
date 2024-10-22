package com.example.mable_assessment_martijn.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.mable_assessment_martijn.model.Category;
import com.example.mable_assessment_martijn.model.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public Optional<Category> findCategory(Long id){
        return categoryRepository.findById(id);
    }
    public boolean exists(Long id){
        return categoryRepository.existsById(id);
    }

    public List<Category> getCategoriesAndArticles(){
        return categoryRepository.findAll();
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
