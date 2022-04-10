package com.example.demo.movie;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movie")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

//    @Autowired
//    public MovieController(MovieService movieService) {
//        this.movieService = movieService;
//    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }
}
