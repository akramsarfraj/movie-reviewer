package com.agavian.agavianproject.controller;

import com.agavian.agavianproject.model.Reviews;
import com.agavian.agavianproject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping("/movies/{movieId}/reviews")
    public ResponseEntity<String> addReviews(@RequestBody Reviews reviews, @PathVariable("movieId") int movieId){
       return service.addReview(movieId,reviews);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable("reviewId") int reviewId, @RequestBody Reviews reviews){
        return service.updateReviews(reviewId,reviews);
    }
}
