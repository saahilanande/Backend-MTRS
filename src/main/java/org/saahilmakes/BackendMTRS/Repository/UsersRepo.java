package org.saahilmakes.BackendMTRS.Repository;

import org.saahilmakes.BackendMTRS.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<UserModel, Long> {
}
