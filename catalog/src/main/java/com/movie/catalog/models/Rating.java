package com.movie.catalog.models;

import lombok.Getter;

@Getter
public class Rating {

  private String movieId;
  private int rating;

  public Rating() {}

  public Rating(String movieId, int rating) {
    this.movieId = movieId;
    this.rating = rating;
  }
}
