package com.movie.catalog.controllers;

import com.movie.catalog.models.CatalogItem;
import com.movie.catalog.models.Movie;
import com.movie.catalog.models.Rating;
import com.movie.catalog.models.UserRating;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
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
    UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId,
        UserRating.class);

    return ratings.getUserRating().stream().map(rating -> {
      // for each movie ID call movie info services and get movies information back
      Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
      // Put them all together
      return new CatalogItem(movie.getMovieTitle(), "About True Detective Movie",
          rating.getRating());
    })
        .collect(Collectors.toList());
  }

}


/**

 Movie movie = webClientBuilder.build()
 .get()
 .uri("http://localhost:8082/movies/" + rating.getMovieId())
 .retrieve()
 .bodyToMono(Movie.class)
 .block();
 *
 */
