package com.agavian.agavianproject.service;

import com.agavian.agavianproject.model.Movies;
import com.agavian.agavianproject.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MoviesRepository repository;

    public ResponseEntity<String> addMovies(Movies movies){
        repository.save(movies);
        return ResponseEntity.status(HttpStatus.CREATED).body("Movie Added");
    }

    public ResponseEntity<List<Movies>> getMovies(){
        List<Movies> movies = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

}
