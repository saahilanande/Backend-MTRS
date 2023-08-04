package org.saahilmakes.BackendMTRS.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "movieshowtime")
@IdClass(MovieShowtimeId.class)
public class MovieShowtimeModel {

    @Id
    private Long movieId;

    private Long theaterId;
    @Id
    private String name;
    private String address;
    private String city;
    @Id
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date movieDate;
    private String startTimes;

    public Long getTheaterId() {
        return theaterId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public Date getMovieDate() {
        return movieDate;
    }

    public String getStartTimes() {
        return startTimes;
    }
}
