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

    @PostMapping("/adduser")
    public String add(@RequestBody UserModel userModel){
       String response = userService.AddNewUser(userModel);
       return response;
    }

}
