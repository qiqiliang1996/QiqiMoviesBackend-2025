package com.codewithqiqi.movies;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin(origins = "https://movies-frontend2025-opv8kmx29-kikis-projects-c50f8a1b.vercel.app/")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
      return new ResponseEntity<List<Movie>>(service.findAllMovies().stream().toList(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<>(service.findMovieByImdbId(imdbId), HttpStatus.OK);
    }
}