package com.agavian.agavianproject.repository;

import com.agavian.agavianproject.model.Movies;
import com.agavian.agavianproject.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Reviews,Integer> {
}
