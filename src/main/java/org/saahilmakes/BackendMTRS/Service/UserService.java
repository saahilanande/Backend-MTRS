package org.saahilmakes.BackendMTRS.Service;
import org.saahilmakes.BackendMTRS.Model.UserModel;
import org.saahilmakes.BackendMTRS.Repository.UsersRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UsersRepo usersRepo;

    public UserService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public List<UserModel> GetAllUser(){
        List<UserModel> allUser = usersRepo.findAll();
        return  allUser;
    }

    public String AddNewUser(UserModel userModel){ //Takes Parameter from Request body of post request to set Usermodel object

        UserModel newUser = new UserModel(); //Creating a new usermodel object to set and passing it to save method
        newUser.setUsername(userModel.getUsername());
        newUser.setEmail(userModel.getEmail());
        newUser.setPassword(userModel.getPassword());
        newUser.setRole(userModel.getRole());
        newUser.setPhone(userModel.getPhone());
        try {
            usersRepo.save(newUser); //add a user to database
        }
        catch (Exception ex){
            return ""+ex;
        }
        return "User Added Succesfully";
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
}
