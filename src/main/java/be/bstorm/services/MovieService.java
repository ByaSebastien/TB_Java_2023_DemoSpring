package be.bstorm.services;

import be.bstorm.models.entities.Movie;
import be.bstorm.repositories.MovieRepository;

import java.util.List;

public interface MovieService {

    Movie create(Movie movie);

    Movie findOne(Long id);

    List<Movie> findAll();

    List<Movie> searchByTitle(String title);

    Movie update(Long id,Movie movie);

    Movie delete(Long id);
}
