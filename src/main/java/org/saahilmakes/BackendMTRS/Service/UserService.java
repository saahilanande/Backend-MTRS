package org.saahilmakes.BackendMTRS.Service;
import org.saahilmakes.BackendMTRS.Model.UserModel;
import org.saahilmakes.BackendMTRS.Repository.UsersRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UsersRepo usersRepo;
    private final AuthenticationManager authenticationManager;

    public UserService(UsersRepo usersRepo, AuthenticationManager authenticationManager) {
        this.usersRepo = usersRepo;
        this.authenticationManager = authenticationManager;
    }

    public List<UserModel> GetAllUser(){
        List<UserModel> allUser = usersRepo.findAll();
        return  allUser;
    }

    public String AddNewUser(UserModel userModel){ //Takes Parameter from Request body of post request

        try {
            boolean emailExist = usersRepo.findEmail(userModel.getEmail()); //Check for email
            if(!emailExist){ //If email does not exist in the database
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

    public String ValidateUser(String email,String password){ //Service used for validating User by email and password
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        }
        catch (BadCredentialsException ex){
            return "Invalid User " + ex;
        }
        return "User validated";
    }
}
