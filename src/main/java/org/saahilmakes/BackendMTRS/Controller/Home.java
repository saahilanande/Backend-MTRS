package org.saahilmakes.BackendMTRS.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping("/")
    public String homeUrl(){
        return "Welcome to MTRS Checkout code @ https://github.com/saahilanande/Backend-MTRS, Try endpoints in postman /user /movie /theatre /book";
    }

}
