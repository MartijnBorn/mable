package com.example.mable_assessment_martijn.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonBackReference; // Add this import
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Article {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "CategoryID")
    @JsonBackReference  // Prevents serialization of the Category reference in Article
    private Category category;

    private String name;
    private LocalDateTime dateAdded;
    private double price;
    private boolean discount;
    private double discountPrice;

    public Article(String id, Category category, String name, LocalDateTime dateAdded, double price, boolean discount,
                   double discountPrice) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.dateAdded = dateAdded;
        this.price = price;
        this.discount = discount;
        this.discountPrice = discountPrice;
    }

    public Article() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    
}
