package org.saahilmakes.BackendMTRS.Service;

import org.saahilmakes.BackendMTRS.Model.ShowtimeModel;
import org.saahilmakes.BackendMTRS.Repository.ShowtimeRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Executable;
import java.util.List;

@Service
public class ShowtimeService {

    private final ShowtimeRepo showtimeRepo;

    public ShowtimeService(ShowtimeRepo showtimeRepo) {
        this.showtimeRepo = showtimeRepo;
    }

    //This service to get all the showtimes for a movie
    public List<ShowtimeModel> getShowtime(Long id) {
        try{List<ShowtimeModel> times = showtimeRepo.findShowtime(id);
            return times;}
        catch (Exception ex){
            return (List<ShowtimeModel>) ex;
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
