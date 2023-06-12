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
    public String add(@RequestBody @Valid UserModel userModel){
       String response = userService.AddNewUser(userModel); //Using Add new user method from Service class which takes Usermodel as argument to set varaibles
       return response;
    }

    @DeleteMapping("/delete/{id}")//Endpoint to delete a single user in database by its ID
    public String delete(@PathVariable("id") Long id){
        String response = userService.DeleteUser(id);
        return response;
    }

    @PostMapping("/login/{email}/{password}")
    public ResponseEntity login(@PathVariable("email") @NotBlank @Email String email, @PathVariable("password") @NotBlank String password){
        ResponseEntity response = userService.ValidateUser(email,password);
        return response;
    }

}
