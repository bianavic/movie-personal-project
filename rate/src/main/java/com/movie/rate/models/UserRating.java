package com.movie.rate.models;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRating {

  private String userId;
  private List<Rating> ratings;

  public List<Rating> getRatings() {
    return ratings;
  }

  public void setRatings(List<Rating> ratings) {
    this.ratings = ratings;
  }

  public void initData(String userId) {
    this.setUserId(userId);
    this.setRatings(Arrays.asList(
        new Rating("100", 5),
        new Rating("500", 3)
    ));
  }
}
