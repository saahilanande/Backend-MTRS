package org.saahilmakes.BackendMTRS.Service;

import org.saahilmakes.BackendMTRS.Model.MovieModel;
import org.saahilmakes.BackendMTRS.Repository.MovieRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepo movieRepo;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    //Get all movies service
    public List<MovieModel> getLatestMovies(int pageNo , int pageSize) {
        Sort sort = Sort.by("releaseDate").descending(); //Sorting by release date
        Pageable sortedByYear = PageRequest.of(pageNo, pageSize,sort); //Applying pagination

        Page<MovieModel> getTheLatestMovies = movieRepo.findAll(sortedByYear);
        List<MovieModel> listOfMovies = getTheLatestMovies.getContent();

        return listOfMovies;
    }

    //Add a new movie
    public ResponseEntity<Object> addNewMovie(MovieModel movieModel){
        try{
            movieRepo.save(movieModel);
            return new ResponseEntity<>("Movie Added Succesfully", HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(""+ex, HttpStatus.BAD_REQUEST);
        }
    }

}
