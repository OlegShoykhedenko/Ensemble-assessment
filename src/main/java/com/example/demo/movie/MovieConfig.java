package com.example.demo.movie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MovieConfig {

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository repository) {
        return args -> {
            Movie movie1 = new Movie(
                    "Movie 1",
                    "description",
                    2000,
                    4.93,
                    10,
                    2

            );

            Movie movie2 = new Movie(
                    "Movie 2",
                    "description",
                    2002,
                    4.52,
                    8,
                    4

            );
            repository.saveAll(
                    List.of(movie1, movie2)
            );
        };
    }
}
