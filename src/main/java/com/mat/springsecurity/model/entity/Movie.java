package com.mat.springsecurity.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Setter
    @Lob
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Lob
    @Column(name = "director", nullable = false)
    private String director;

    @Lob
    @Column(name = "plot", nullable = false)
    private String plot;

    @Lob
    @Column(name = "poster", nullable = false)
    private String poster;

    @Lob
    @Column(name = "imdb", nullable = false)
    private String imdb;

    @Lob
    @Column(name = "tmdb", nullable = false)
    private String tmdb;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Category genre;

    @Column(name = "\"createdAt\"", nullable = false)
    private Instant createdAt;

    @Column(name = "\"updatedAt\"", nullable = false)
    private Instant updatedAt;

    @OneToMany(mappedBy = "movie")
    private Set<Review> reviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "movie")
    private Set<Actor> actors = new LinkedHashSet<>();
}