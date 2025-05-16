package com.codewithqiqi.movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "https://movies-frontend2025-7hgx3e3ny-kikis-projects-c50f8a1b.vercel.app")
public class ReviewController {
    @Autowired
    private ReviewService service;

    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<Review>(service.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.OK);
    }
}