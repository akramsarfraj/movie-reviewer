package com.agavian.agavianproject.controller;

import com.agavian.agavianproject.model.Movies;
import com.agavian.agavianproject.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping("/movies")
    public ResponseEntity<String> addMovie(@RequestBody Movies movies){
        return service.addMovies(movies);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movies>> getMovies(){
        return service.getMovies();
    }
}
