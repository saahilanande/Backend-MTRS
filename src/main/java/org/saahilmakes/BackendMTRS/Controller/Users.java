package org.saahilmakes.BackendMTRS.Controller;

import org.saahilmakes.BackendMTRS.Model.UserModel;
import org.saahilmakes.BackendMTRS.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Users {

    private final UserService userService;

    public Users(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<UserModel> getAllUser(){

        List<UserModel> allUser = userService.GetAllUser();
        return allUser;
    }

    @PostMapping("/signup") //Endpoint to add a new user in database
    public String add(@RequestBody UserModel userModel){
       String response = userService.AddNewUser(userModel); //Using Add new user method from Service class which takes Usermodel as argument to set varaibles
       return response;
    }

    @DeleteMapping("/delete/{id}")//Endpoint to delete a single user in database by its ID
    public String delete(@PathVariable("id") Long id){
        String response = userService.DeleteUser(id);
        return response;
    }

}
