package org.saahilmakes.BackendMTRS.Controller;

import org.saahilmakes.BackendMTRS.Model.MovieModel;
import org.saahilmakes.BackendMTRS.Service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class Movie {

    private final MovieService movieService;

    public Movie(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/latest")
    public List<MovieModel> getAllMovies() {

        List<MovieModel> movies = movieService.getLatestMovies();
        return movies;
    }


}
