package com.example.mable_assessment_martijn.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import java.util.List;

@Entity
public class GroceryList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "groceryList_article",
        joinColumns = @JoinColumn(name="grocerylist_id"),
        inverseJoinColumns = @JoinColumn(name = "article_id")
    )
    private List<Article> articles;
    
    public GroceryList(String name, List<Article> articles) {
        this.name = name;
        this.articles = articles;
    }

    public GroceryList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    
}
