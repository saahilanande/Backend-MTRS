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

    public List<MovieModel> getLatestMovies() {
        int pageNo = 0;
        int pageize = 10;

        Sort sort = Sort.by("rating").descending();
        Pageable sortedByYear = PageRequest.of(0, 3,sort);

        Page<MovieModel> getTheLatestMovies = movieRepo.findAll(sortedByYear);
        List<MovieModel> listOfMovies = getTheLatestMovies.getContent();

        return listOfMovies;
    }

}
