package com.gfg.shoutreview.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gfg.shoutreview.service.response.ReviewResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name="review_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Review 
{
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String movieReview;

    private double rating;  // rating dedicated to each review.

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="movie_id", nullable=false)
    @JsonIgnore
    private Movie movie; // it will add foregion key in mysql table with <TABLE_NAME>_<ID_NAME> --> // movie_movie_id

    @Temporal(value = TemporalType.DATE)
    @CreationTimestamp
    private Date createdDate;

    @Temporal(value = TemporalType.DATE)
    @UpdateTimestamp
    private Date updatedDate;

    public static ReviewResponse toReviewResponse(Review review)
    {
        return ReviewResponse
        			.builder()
        			.review(review.movieReview)
        			.rating(review.rating)
        			.build();
    }

    public static List<ReviewResponse> toReviewResponse(List<Review> reviewList)
    {
        if(Objects.isNull(reviewList))
        {
            return new ArrayList<>();
        }
        else
        {
            return reviewList
            		.stream()
            		.map(review -> Review.toReviewResponse(review)) // Review::toReviewResponse
            		.collect(Collectors.toList());
        }
    }
}
