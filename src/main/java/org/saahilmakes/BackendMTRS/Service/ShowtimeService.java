package org.saahilmakes.BackendMTRS.Service;

import org.saahilmakes.BackendMTRS.Model.MovieShowtimeModel;
import org.saahilmakes.BackendMTRS.Model.ShowtimeModel;
import org.saahilmakes.BackendMTRS.Repository.MovieShowtimeRepo;
import org.saahilmakes.BackendMTRS.Repository.ShowtimeRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowtimeService {

    private final ShowtimeRepo showtimeRepo;

    private final MovieShowtimeRepo movieShowtimeRepo;

    public ShowtimeService(ShowtimeRepo showtimeRepo, MovieShowtimeRepo movieShowtimeRepo) {
        this.showtimeRepo = showtimeRepo;
        this.movieShowtimeRepo = movieShowtimeRepo;
    }

    //This service to get all the showtimes for a movie
    public List<MovieShowtimeModel> getShowtime(Long id) {
        try{
            List<MovieShowtimeModel> times = movieShowtimeRepo.findShowtime(id);
            return times;}
        catch (Exception ex){
            return (List<MovieShowtimeModel>) ex;
        }

    }

    //This endpoint add a showtime for a movie
    public ResponseEntity<Object> addShowtime(ShowtimeModel showtimeModel) {

        try {
            showtimeRepo.save(showtimeModel);
            return new ResponseEntity<>("Showtime Added Succesfully", HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(""+ex, HttpStatus.BAD_REQUEST);
        }

    }

}
