package com.movie.catalog.models;

import lombok.Getter;

@Getter
public class CatalogItem {

  private String movieTitle;
  private String description;
  private int rate;

  public CatalogItem(String movieTitle, String description, int rate) {
    this.movieTitle = movieTitle;
    this.description = description;
    this.rate = rate;
  }
}
