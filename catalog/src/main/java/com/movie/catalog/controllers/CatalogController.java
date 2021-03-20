package com.movie.catalog.controllers;

import com.movie.catalog.models.CatalogItem;
import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

  @RequestMapping("/{userId}")
  public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
    return Collections.singletonList(new CatalogItem("True Detective", "About True Detective Movie", 4));
  }

}
