package com.movie.catalog.models;

import lombok.Getter;

@Getter
public class Movie {

  private String movieId;
  private String movieTitle;
  private String description;

  public Movie() {}

  public Movie(String movieId, String movieTitle, String description) {
    this.movieId = movieId;
    this.movieTitle = movieTitle;
    this.description = description;
  }
}
