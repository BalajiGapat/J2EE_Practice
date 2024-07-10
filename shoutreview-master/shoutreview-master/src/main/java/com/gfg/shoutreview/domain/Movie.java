package com.gfg.shoutreview.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gfg.shoutreview.service.response.MovieResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="movie_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Movie implements Serializable 
{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(value=EnumType.STRING)
    @Column(length = 50)
    private Genre genre;

    private Double rating;// a single entity which is average rating of all reviews for a movie

    @OneToMany(mappedBy="movie", cascade=CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    private List<Review> reviews;

    public  MovieResponse toMovieResponse()
    {
        return MovieResponse
        			.builder()
        			.genre(this.genre)
        			.title(this.title)
        			.rating(this.rating)
        			.reviews(Review.toReviewResponse(this.reviews))
        			.build();
    }

}
