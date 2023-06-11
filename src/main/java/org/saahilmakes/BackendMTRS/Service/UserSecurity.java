package org.saahilmakes.BackendMTRS.Service;

import org.saahilmakes.BackendMTRS.Model.UserModel;
import org.saahilmakes.BackendMTRS.Repository.UsersRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserSecurity implements UserDetailsService {

    private final UsersRepo usersRepo;

    public UserSecurity(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
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
