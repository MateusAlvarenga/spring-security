package com.mat.springsecurity.model.service;

import com.mat.springsecurity.model.entity.Movie;
import com.mat.springsecurity.model.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class MovieService {

    @Autowired MovieRepository movieRepository;

    public List<Movie> readMovies(Pageable pageable) {
        return movieRepository.findAll();
    }
}
