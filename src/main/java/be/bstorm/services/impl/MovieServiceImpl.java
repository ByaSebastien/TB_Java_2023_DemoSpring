package be.bstorm.services.impl;

import be.bstorm.models.entities.Movie;
import be.bstorm.repositories.MovieRepository;
import be.bstorm.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie create(Movie movie) {
        if(movieRepository.existsByTitle(movie.getTitle())){
            throw new RuntimeException("Un film avec ce titre existe deja");
        }
        return movieRepository.save(movie);
    }

    @Override
    public Movie findOne(Long id) {
        return movieRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> searchByTitle(String title) {
        return movieRepository.findMoviesByTitleContainingIgnoreCase(title);
    }

    @Override
    public Movie update(Long id, Movie movie) {
        Movie existingMovie = findOne(id);
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setDescription(movie.getDescription());
        return movieRepository.save(existingMovie);
    }

    @Override
    public Movie delete(Long id) {
        //Si pas besoin de return le movie :
//        movieRepository.deleteById(id);
        Movie existingMovie = findOne(id);
        movieRepository.delete(existingMovie);
        return existingMovie;
    }
}
