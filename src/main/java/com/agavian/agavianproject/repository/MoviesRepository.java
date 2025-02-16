package com.agavian.agavianproject.repository;

import com.agavian.agavianproject.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movies,Integer> {
}
