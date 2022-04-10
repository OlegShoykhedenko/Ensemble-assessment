package com.example.demo.movie;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get")
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @PostMapping("/add")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @DeleteMapping(path = "/delete/{movieId}")
    public void deleteMovie(@PathVariable("movieId") Long movieId) {
        movieService.deleteMovie(movieId);
    }

    @PutMapping(path = "/update/{movieId}")
    public void updateMovie(
            @PathVariable("movieId") Long movieID,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Integer releaseYear,
            @RequestParam(required = false) Double rating,
            @RequestParam(required = false) Integer likeCount,
            @RequestParam(required = false) Integer dislikeCount ) {
        movieService.updateMovie(movieID, title, description, releaseYear, rating, likeCount, dislikeCount);
    }

}



