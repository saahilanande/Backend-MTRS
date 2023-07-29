package org.saahilmakes.BackendMTRS.Repository;

import org.saahilmakes.BackendMTRS.Model.MovieShowtimeModel;
import org.saahilmakes.BackendMTRS.Model.ShowtimeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieShowtimeRepo extends JpaRepository<MovieShowtimeModel, Long> {

    @Query(value = "select * from movieshowtime where movie_id = :id", nativeQuery = true)
    List<ShowtimeModel> findShowtime(Long id);

}
