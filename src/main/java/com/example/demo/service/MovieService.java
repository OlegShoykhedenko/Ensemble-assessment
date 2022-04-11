package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.repo.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    private Movie findMovieById(Long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "movie with id " + movieId + " does not exists"
                ));
    }

    public void deleteMovie(Long movieId) {
        if(!movieRepository.existsById(movieId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "movie with id " + movieId + " does not exists"
            );
        }
        movieRepository.deleteById(movieId);
    }

    public void updateMovie(Movie movie, Long movieId) {
        Movie updatedMovie = findMovieById(movieId);

        boolean needUpdate = false;
        if (movie.getTitle() != null && movie.getTitle().length() > 0
                && !Objects.equals(movie.getTitle(), updatedMovie.getTitle())) {
            updatedMovie.setTitle(movie.getTitle());
            needUpdate = true;
        }

        if (movie.getDescription() != null && movie.getDescription().length() > 0
                && !Objects.equals(movie.getDescription(), updatedMovie.getDescription())) {
            updatedMovie.setDescription(movie.getDescription());
            needUpdate = true;
        }

        if (movie.getReleaseYear() != null
                && !Objects.equals(movie.getReleaseYear(), updatedMovie.getReleaseYear())) {
            updatedMovie.setReleaseYear(movie.getReleaseYear());
            needUpdate = true;
        }

        if (movie.getRating() != null && movie.getRating() >= 0 &&
                !Objects.equals(movie.getRating(), updatedMovie.getRating())) {
            updatedMovie.setRating(movie.getRating());
            needUpdate = true;
        }

        if (movie.getLikeCount() != null && movie.getLikeCount() >= 0
                && !Objects.equals(movie.getLikeCount(), updatedMovie.getLikeCount())) {
            updatedMovie.setLikeCount(movie.getLikeCount());
            needUpdate = true;
        }

        if (movie.getDislikeCount() != null && movie.getDislikeCount() >= 0
                && !Objects.equals(movie.getDislikeCount(), updatedMovie.getDislikeCount())) {
            updatedMovie.setDislikeCount(movie.getDislikeCount());
            needUpdate = true;
        }

        if(needUpdate){
            movieRepository.save(updatedMovie);
        }
    }

    public void likeMovie(Long movieId) {
        Movie movie = findMovieById(movieId);

        movie.setLikeCount(movie.getLikeCount() + 1);
        movieRepository.save(movie);
    }

    public void dislikeMovie(Long movieId) {
        Movie movie = findMovieById(movieId);

        movie.setDislikeCount(movie.getDislikeCount() + 1);
        movieRepository.save(movie);
    }

    public List<Movie> searchByTitle(String title) {
        return movieRepository.findMovieByTitleContaining(title);
    }

}
