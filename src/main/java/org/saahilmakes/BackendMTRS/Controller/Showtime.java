package org.saahilmakes.BackendMTRS.Controller;

import org.saahilmakes.BackendMTRS.Model.ShowtimeModel;
import org.saahilmakes.BackendMTRS.Service.ShowtimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/showtime")
public class Showtime {

    public Showtime(ShowtimeService showtimeService) {
        this.showtimeService = showtimeService;
    }

    private final ShowtimeService showtimeService;

    //This endpoint get all the showtimes for a movie
    @GetMapping("/{id}")
    public List<ShowtimeModel> getMovieShowtime(@PathVariable Long id){
        return showtimeService.getShowtime(id);
    }

}
