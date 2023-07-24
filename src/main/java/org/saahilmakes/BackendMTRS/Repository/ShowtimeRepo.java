package org.saahilmakes.BackendMTRS.Repository;

import org.saahilmakes.BackendMTRS.Model.ShowtimeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepo extends JpaRepository<ShowtimeModel, Long> {

}
