package com.example.mable_assessment_martijn.model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface GroceryListRepository extends JpaRepository<GroceryList, Long>{
    List<GroceryList> findByName(String name);
    boolean existsByName(String name);
}
