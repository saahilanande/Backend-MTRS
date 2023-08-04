package org.saahilmakes.BackendMTRS.Service;

import org.saahilmakes.BackendMTRS.Model.TheaterModel;
import org.saahilmakes.BackendMTRS.Repository.TheaterRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    public TheaterService(TheaterRepo theaterRepo) {
        this.theaterRepo = theaterRepo;
    }

    private final TheaterRepo theaterRepo;

    public List<TheaterModel> getTheater(){
       return theaterRepo.findAll();

    }
}
