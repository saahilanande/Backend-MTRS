package org.saahilmakes.BackendMTRS.Controller;

import org.saahilmakes.BackendMTRS.Model.TheaterModel;
import org.saahilmakes.BackendMTRS.Service.TheaterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}
