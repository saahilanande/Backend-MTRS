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

    public String AddNewUser(UserModel userModel){ //Takes Parameter from Request body of post request

        try {
            List<UserModel> emailExist = usersRepo.findEmail(userModel.getEmail()); //Check for email
            if(emailExist.isEmpty()){
                usersRepo.save(userModel); //add a user to database
                return "User Added Succesfully";
            }
            else {
                return "Email exist";
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
}
