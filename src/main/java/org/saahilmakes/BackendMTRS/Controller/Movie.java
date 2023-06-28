package org.saahilmakes.BackendMTRS.Controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.saahilmakes.BackendMTRS.Model.MovieModel;
import org.saahilmakes.BackendMTRS.Service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class Movie {

    private final MovieService movieService;

    public Movie(MovieService movieService) {
        this.movieService = movieService;
    }

    //Get all the movies from the database
    @GetMapping("/")
    public List<MovieModel> getAllMovies(@Min(value = 0) @Max(value = 300) @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pNo,@Min(value = 10) @Max(value = 50) @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pSize) {
        List<MovieModel> movies = movieService.getLatestMovies(pNo, pSize);
        return movies;
    }

    //Add a new movie
    @PostMapping("/add")
    public ResponseEntity addNewMovie(@RequestBody MovieModel movieModel){
        ResponseEntity response = movieService.addNewMovie(movieModel);
        return response;
    }


}
