package com.example.demo.movie;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movie")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

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

    @PatchMapping("/update/{movieId}")
    public void updateMovie(@RequestBody Movie movie, @PathVariable Long movieId) {
        movieService.updateMovie(movie, movieId);
    }

    @PatchMapping("/like/{movieId}")
    public void likeMovie(@PathVariable Long movieId) {
        movieService.likeMovie(movieId);
    }

    @PatchMapping("/dislike/{movieId}")
    public void dislikeMovie(@PathVariable Long movieId) {
        movieService.dislikeMovie(movieId);
    }

    @GetMapping("/searchByTitle")
    public List<Movie> searchByTitle(@Param("title") String title) {
        return movieService.searchByTitle(title);
    }
}



