package org.saahilmakes.BackendMTRS.Controller;

import org.saahilmakes.BackendMTRS.Model.ShowtimeModel;
import org.saahilmakes.BackendMTRS.Service.ShowtimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public ResponseEntity<Object> addshowtime(@RequestBody ShowtimeModel showtimeModel){
        return showtimeService.addShowtime(showtimeModel);
    }

}
