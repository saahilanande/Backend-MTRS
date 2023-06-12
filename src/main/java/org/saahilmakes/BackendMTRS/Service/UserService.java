package org.saahilmakes.BackendMTRS.Service;
import org.saahilmakes.BackendMTRS.Model.UserModel;
import org.saahilmakes.BackendMTRS.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final UsersRepo usersRepo;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public UserService(UsersRepo usersRepo, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.usersRepo = usersRepo;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @Autowired
    PasswordEncoder passwordEncode;

    public List<UserModel> GetAllUser(){
        try {
            List<UserModel> allUser = usersRepo.findAll();
            return  allUser;
        }
        catch (Exception ex){
            List<UserModel> EmptyUser = null;
            return  EmptyUser;
        }
        
    }

    public String AddNewUser(UserModel userModel){ //Takes Parameter from Request body of post request

        try {
            boolean emailExist = usersRepo.findEmail(userModel.getEmail()); //Check for email
            if(!emailExist){ //If email does not exist in the database
                userModel.setPassword(passwordEncode.encode(userModel.getPassword())); //Encoding password before saving
                usersRepo.save(userModel); //add a user to database
                return "User Added Succesfully";
            }
            else { //If the email exist
                return "Email already exist";
            }
        }
        catch (Exception ex){
            return ""+ex;
        }
    }

    public String DeleteUser(Long id){
        try {
            usersRepo.deleteById(id); // using the delete method from JPA and passing id from path variable
        }
        catch (Exception ex){
            return ""+ex;
        }
        return "Successfully Deleted user by ID" + id;
    }

    public ResponseEntity<Object> ValidateUser(String email, String password){ //Service used for validating User by email and password
        Map<String, String> data; // Create a object to return the token and email of the user
        data = new HashMap<>();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password)); //Check if the username pass is correct
            String token = tokenService.generateToken(email);// Signing and generating a JWT token
            data.put("message","Login successful");
            data.put("email", email);
            data.put("jwt", token);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (BadCredentialsException ex){
            return new ResponseEntity<>("Invalid email or password", HttpStatus.FORBIDDEN);
        }
    }
}
