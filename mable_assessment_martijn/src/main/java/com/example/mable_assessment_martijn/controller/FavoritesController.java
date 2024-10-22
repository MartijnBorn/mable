package com.example.mable_assessment_martijn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mable_assessment_martijn.service.FavoriteService;

@Controller
@RequestMapping("/favorite")
public class FavoritesController {
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("")
    public ResponseEntity<?> getFavorites(){
        return new ResponseEntity<>(favoriteService.getFavorites(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addFavorite(@RequestBody String id){
        favoriteService.addFavorite(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
