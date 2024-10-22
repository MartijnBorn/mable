package com.example.mable_assessment_martijn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mable_assessment_martijn.model.GroceryList;
import com.example.mable_assessment_martijn.service.GroceryListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@Controller
@RequestMapping("/list")
public class GroceryListController {
    @Autowired
    GroceryListService groceryListService;


    @GetMapping("/{name}")
    public ResponseEntity<?> getMethodName(@PathVariable String name) {
        return new ResponseEntity<>(groceryListService.getGroceryList(name), HttpStatus.OK);
    }

    @PostMapping("/{name}")
    public ResponseEntity<?> postGroceryList(@PathVariable String name, @RequestBody List<String> articleIds){
        GroceryList groceryList = groceryListService.createAndSaveGroceryList(name, articleIds);
        if(groceryList == null){
            return new ResponseEntity<>("Name already taken", HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(groceryList, HttpStatus.OK);
        }
        
    }
    
}
