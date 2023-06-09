package org.saahilmakes.BackendMTRS.Repository;

import org.saahilmakes.BackendMTRS.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepo extends JpaRepository<UserModel, Long> {

    //Check for email
    @Query(value = "select case when count(*) > 0 then true else false end from users where email = :email", nativeQuery = true)
    boolean findEmail(String email);


    //Getting
    @Query(value = "select * from users where email = :email", nativeQuery = true)
    UserModel getUserDetailsbyEmail(String email);


}
