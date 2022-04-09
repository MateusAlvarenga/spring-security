package com.mat.springsecurity.model.repository;

import com.mat.springsecurity.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}