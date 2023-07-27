package org.saahilmakes.BackendMTRS.Controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.saahilmakes.BackendMTRS.Model.MovieModel;
import org.saahilmakes.BackendMTRS.Service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class Movie {

    private final MovieService movieService;

    public Movie(MovieService movieService) {
        this.movieService = movieService;
    }

    //Get all the movies from the database
    @GetMapping("/")
    public List<MovieModel> getAllMovies(@Min(value = 0) @Max(value = 300) @RequestParam(value = "pageNo", required = false, defaultValue = "0") int pNo, @Min(value = 10) @Max(value = 50) @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pSize) {
        List<MovieModel> movies = movieService.getLatestMovies(pNo, pSize);
        return movies;
    }

    //Get movie with ID
    @GetMapping("/{id}")
    public Optional<MovieModel> getMovieDetail(@PathVariable Long id) {
        return movieService.getMovieDetails(id);
    }

    //Add a new movie endpoint
    @PostMapping("/add")
    public ResponseEntity addNewMovie(@RequestBody MovieModel movieModel) {
        ResponseEntity response = movieService.addNewMovie(movieModel);
        return response;
    }

    //Delete a movie by Id endpoint
    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") Long id) {
        String response = movieService.deleteMovie(id);
        return response;
    }


}
