package com.movie.info.models;

import lombok.Getter;

@Getter
public class Movie {

  private String movieId;
  private String movieTitle;

  public Movie(String movieId, String movieTitle) {
    this.movieId = movieId;
    this.movieTitle = movieTitle;
  }
}
