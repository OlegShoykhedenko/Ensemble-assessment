package com.example.demo.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @DeleteMapping("{movieId}")
    public void deleteMovie(@PathVariable("movieId") Long movieId) {
        movieService.deleteMovie(movieId);
    }

    @PatchMapping("{movieId}")
    public void updateMovie(@RequestBody Movie movie, @PathVariable Long movieId) {
        movieService.updateMovie(movie, movieId);
    }

    @PatchMapping("{movieId}/like")
    public void likeMovie(@PathVariable Long movieId) {
        movieService.likeMovie(movieId);
    }

    @PatchMapping("{movieId}/dislike")
    public void dislikeMovie(@PathVariable Long movieId) {
        movieService.dislikeMovie(movieId);
    }

    @GetMapping("searchByTitle")
    public List<Movie> searchByTitle(@Param("title") String title) {
        return movieService.searchByTitle(title);
    }
}
