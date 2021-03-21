package com.movie.catalog.controllers;

import com.movie.catalog.models.CatalogItem;
import com.movie.catalog.models.Movie;
import com.movie.catalog.models.UserRating;
import com.netflix.discovery.DiscoveryClient;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private WebClient.Builder webClientBuilder;

  @RequestMapping("/{userId}")
  public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

    // get all rated movie IDs
    UserRating ratings = restTemplate.getForObject("http://movie-ratings-service/ratingsdata/users/" + userId,
        UserRating.class);

    return ratings.getRatings().stream().map(rating -> {
      // for each movie ID call movie info services and get movies information back
      Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
      // Put them all together
      return new CatalogItem(movie.getMovieTitle(), movie.getDescription(),
          rating.getRating());
    })
        .collect(Collectors.toList());
  }

}
