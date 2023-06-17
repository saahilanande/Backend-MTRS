package org.saahilmakes.BackendMTRS.Controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.saahilmakes.BackendMTRS.Model.UserModel;
import org.saahilmakes.BackendMTRS.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/user")
@CrossOrigin
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
    public ResponseEntity<Object> add(@RequestBody @Valid UserModel userModel){
       ResponseEntity<Object> response = userService.AddNewUser(userModel); //Using Add new user method from Service class which takes Usermodel as argument to set varaibles
       return response;
    }

    @DeleteMapping("/delete/{id}")//Endpoint to delete a single user in database by its ID
    public String delete(@PathVariable("id") Long id){
        String response = userService.DeleteUser(id);
        return response;
    }

    @PostMapping("/login/{email}/{password}") //Endpoint to validate user with the database
    public ResponseEntity login(@PathVariable("email") @NotBlank @Email String email, @PathVariable("password") @NotBlank String password){
        ResponseEntity response = userService.ValidateUser(email,password);
        return response;
    }

}
