package com.example.demo.movie;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId) {
        boolean exists = movieRepository.existsById(movieId);
        if(!exists) {
            throw new IllegalStateException(
                    "movie with id " + movieId + " does not exists"
            );
        }
        movieRepository.deleteById(movieId);
    }

    @Transactional
    public void updateMovie(Long movieID,
                            String title,
                            String description,
                            Integer releaseYear,
                            Double rating,
                            Integer likeCount,
                            Integer dislikeCount) {
        Movie movie = movieRepository.findById(movieID)
                .orElseThrow(() -> new IllegalStateException(
                        "movie with id " + movieID + " does not exists"
                ));

        if(title != null && title.length() > 0 && !Objects.equals(movie.getTitle(), title)) {
            movie.setTitle(title);
        }

        if(description != null && description.length() > 0 && !Objects.equals(movie.getDescription(), description)) {
            movie.setDescription(description);
        }

        if(releaseYear != null &&
                releaseYear >= 1895 &&
                releaseYear <= Calendar.getInstance().get(Calendar.YEAR) &&
                !Objects.equals(movie.getReleaseYear(), releaseYear)) {
            movie.setReleaseYear(releaseYear);
        }

        if(rating != null && rating >= 0 && !Objects.equals(movie.getRating(), rating))
            movie.setRating(rating);

        if(likeCount != null && likeCount >= 0 && !Objects.equals(movie.getLikeCount(), likeCount))
            movie.setLikeCount(likeCount);

        if(dislikeCount != null && dislikeCount >= 0 && !Objects.equals(movie.getDislikeCount(), dislikeCount))
            movie.setDislikeCount(dislikeCount);
    }

}
