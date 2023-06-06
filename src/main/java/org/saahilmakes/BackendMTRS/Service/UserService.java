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

    public String AddNewUser(UserModel userModel){

        UserModel newUser = new UserModel();
        newUser.setUsername(userModel.getUsername());
        newUser.setEmail(userModel.getEmail());
        newUser.setPassword(userModel.getPassword());
        newUser.setRole(userModel.getRole());
        newUser.setPhone(userModel.getPhone());
        try {
            usersRepo.save(newUser);
        }
        catch (Exception ex){
            return ""+ex;
        }
        return "User Added Succesfully";
    }
}
