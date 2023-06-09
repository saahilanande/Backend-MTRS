package org.saahilmakes.BackendMTRS.Service;
import org.saahilmakes.BackendMTRS.Model.UserModel;
import org.saahilmakes.BackendMTRS.Repository.UsersRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private final UsersRepo usersRepo;

    public UserService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel userFound = usersRepo.getUserDetailsbyEmail(email);
        if (userFound == null) {
            return null;
        }
        return new User(userFound.getUsername(), userFound.getPassword(), new ArrayList<>());
    }
}
