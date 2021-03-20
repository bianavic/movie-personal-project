package com.movie.catalog.models;

import lombok.Getter;

@Getter
public class Movie {

  private String movieId;
  private String movieTitle;

  public Movie() {}

  public Movie(String movieId, String movieTitle) {
    this.movieId = movieId;
    this.movieTitle = movieTitle;
  }
}
