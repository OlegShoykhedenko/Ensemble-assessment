package com.example.demo.movie;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Movie {

    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    private Long id ;
    private String title;
    private String description;
    private Integer releaseYear;
    private Double rating;
    private Integer likeCount;
    private Integer dislikeCount;

    public Movie(String title,
                 String description,
                 Integer releaseYear,
                 Double rating,
                 Integer likeCount,
                 Integer dislikeCount) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.likeCount = likeCount;
        this.dislikeCount = dislikeCount;
    }
}
