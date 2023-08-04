package org.saahilmakes.BackendMTRS.Repository;

import org.saahilmakes.BackendMTRS.Model.TheaterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepo extends JpaRepository<TheaterModel, Long> {
}
