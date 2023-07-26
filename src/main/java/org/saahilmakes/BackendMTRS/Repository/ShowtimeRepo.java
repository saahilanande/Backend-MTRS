package org.saahilmakes.BackendMTRS.Repository;

import org.saahilmakes.BackendMTRS.Model.ShowtimeModel;
import org.saahilmakes.BackendMTRS.Service.ShowtimeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowtimeRepo extends JpaRepository<ShowtimeModel, Long> {

    @Query(value = "select * from showtimes where movie_id = :id", nativeQuery = true)
    List<ShowtimeModel> findShowtime(Long id);

}
