package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
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
}
