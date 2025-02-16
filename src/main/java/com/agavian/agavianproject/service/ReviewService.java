package com.agavian.agavianproject.service;

import com.agavian.agavianproject.model.Movies;
import com.agavian.agavianproject.model.Reviews;
import com.agavian.agavianproject.repository.MoviesRepository;
import com.agavian.agavianproject.repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewsRepository reviewsRepo;

    @Autowired
    private MoviesRepository moviesRepo;

    public ResponseEntity<String> addReview(int movieId, Reviews reviews){

        Optional<Movies> optional = moviesRepo.findById(movieId);

        if( optional.isPresent() ){
            Movies moviesDb = optional.get();
            List<Reviews> list = moviesDb.getReviews();
            list.add(reviews);

            reviews.setMovies(moviesDb);
            reviewsRepo.save(reviews);
            moviesRepo.save(moviesDb);

            return ResponseEntity.status(HttpStatus.CREATED).body("Reviews Added Successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Movie Found");
    }


    public ResponseEntity<String> updateReviews(int reviewId, Reviews reviews){

        Optional<Reviews> optional = reviewsRepo.findById(reviewId);

        if( optional.isPresent() ){
            Reviews reviewsDb = optional.get();
            reviewsDb.setComment(reviews.getComment());
            reviewsDb.setRating(reviews.getRating());

            reviewsRepo.save(reviewsDb);
            return  ResponseEntity.status(HttpStatus.OK).body("Review update successfull");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Reviewer Found");
    }
}
