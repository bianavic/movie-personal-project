package com.movie.catalog.models;

import lombok.Getter;

@Getter
public class CatalogItem {

  private String movieTitle;
  private String description;
  private int rating;

  public CatalogItem(String movieTitle, String description, int rating) {
    this.movieTitle = movieTitle;
    this.description = description;
    this.rating = rating;
  }
}
