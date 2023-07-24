package org.saahilmakes.BackendMTRS.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/showtime")
public class Showtime {

    //This endpoint get all the showtimes for a movie
    @GetMapping("/movie/{id}")
    public void getMovieShowtime(@PathVariable Long id){

    }

}
