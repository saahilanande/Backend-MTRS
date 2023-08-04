package org.saahilmakes.BackendMTRS.Service;

import org.saahilmakes.BackendMTRS.Model.TheaterModel;
import org.saahilmakes.BackendMTRS.Repository.TheaterRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {

    public TheaterService(TheaterRepo theaterRepo) {
        this.theaterRepo = theaterRepo;
    }

    private final TheaterRepo theaterRepo;

    public List<TheaterModel> getTheater(){
       return theaterRepo.findAll();

    }

    public Optional<TheaterModel> getTheaterWithId(Long id){
        return theaterRepo.findById(id);
    }

    public ResponseEntity<String> addTheater(TheaterModel theaterModel){
        try {
            theaterRepo.save(theaterModel);
            return new ResponseEntity<>("Theater Added Succesfully", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("" + ex, HttpStatus.BAD_REQUEST);
        }
    }
}
