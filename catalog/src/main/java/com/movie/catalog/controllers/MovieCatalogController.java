package com.movie.catalog.controllers;

import com.movie.catalog.models.CatalogItem;
import com.movie.catalog.models.Rating;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

  @RequestMapping("/{userId}")
  public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

    // get all rated movie IDs
    List<Rating> ratings = Arrays.asList(
        new Rating("Cold Case", 4),
        new Rating("Monk", 4),
        new Rating("Criminal Minds", 4)
    );

    // for each movie ID, call movie info service and get details

    return ratings.stream()
        .map(rating -> new CatalogItem("True Detective", "About True Detective Movie",
            rating.getRating()))
        .collect(Collectors.toList());

    // Put them all together
  }

}
