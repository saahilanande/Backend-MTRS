package org.saahilmakes.BackendMTRS.Service;

import org.saahilmakes.BackendMTRS.Model.MovieModel;
import org.saahilmakes.BackendMTRS.Repository.MovieRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepo movieRepo;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public List<MovieModel> getLatestMovies(int pageNo , int pageSize) {
        Sort sort = Sort.by("releaseDate").descending(); //Sorting by release date
        Pageable sortedByYear = PageRequest.of(pageNo, pageSize,sort); //Applying pagination

        Page<MovieModel> getTheLatestMovies = movieRepo.findAll(sortedByYear);
        List<MovieModel> listOfMovies = getTheLatestMovies.getContent();

        return listOfMovies;
    }

}
