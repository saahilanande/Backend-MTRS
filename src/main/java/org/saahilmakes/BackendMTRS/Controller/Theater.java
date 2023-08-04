package org.saahilmakes.BackendMTRS.Controller;

import org.saahilmakes.BackendMTRS.Model.TheaterModel;
import org.saahilmakes.BackendMTRS.Service.TheaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theater")
public class Theater {

    public Theater(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    private final TheaterService theaterService;

    @GetMapping("/")
    public List<TheaterModel> getTheater(){
        return theaterService.getTheater();
    }

    @GetMapping("/{id}")
    public Optional<TheaterModel> getTheaterWithId(@PathVariable Long id){
        return theaterService.getTheaterWithId(id);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addTheater(@RequestBody TheaterModel theaterModel){
        return theaterService.addTheater(theaterModel) ;
    }


}
