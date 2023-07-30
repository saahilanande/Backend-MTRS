package org.saahilmakes.BackendMTRS.Model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class MovieShowtimeId implements Serializable {

    private Long movieId;

    private String name;
    private Date movieDate;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieShowtimeId that = (MovieShowtimeId) o;
        return movieId.equals(that.movieId) && name.equals(that.name) && movieDate.equals(that.movieDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, name, movieDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(Date movieDate) {
        this.movieDate = movieDate;
    }

}
