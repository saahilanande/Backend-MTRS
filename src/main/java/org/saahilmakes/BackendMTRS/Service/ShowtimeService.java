package org.saahilmakes.BackendMTRS.Service;

import org.saahilmakes.BackendMTRS.Model.ShowtimeModel;
import org.saahilmakes.BackendMTRS.Repository.ShowtimeRepo;
import org.springframework.stereotype.Service;

@Service
public class ShowtimeService {

    private final ShowtimeRepo showtimeRepo;

    public ShowtimeService(ShowtimeRepo showtimeRepo) {
        this.showtimeRepo = showtimeRepo;
    }

    //This service to get all the showtimes for a movie
    public void getShowtime(Long id) {

    }

    //This endpoint add a showtime for a movie with seat capacity
    public void addShowtime() {

    }

}
