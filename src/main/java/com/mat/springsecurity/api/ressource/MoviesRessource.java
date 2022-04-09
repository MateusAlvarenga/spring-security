package com.mat.springsecurity.api.ressource;

import com.mat.springsecurity.model.entity.Movie;
import com.mat.springsecurity.model.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/movies")
public class MoviesRessource {

    @Autowired
    MovieService movieService;

    @GetMapping
    public String getAllMovies(Pageable pageable) {
        return "{Movies :  [title:'teste', description:'teste']}";
    }
}
