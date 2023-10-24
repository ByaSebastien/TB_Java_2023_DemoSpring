package be.bstorm.controllers;

import be.bstorm.models.dtos.movie.MovieDTO;
import be.bstorm.models.dtos.movie.MovieShortDTO;
import be.bstorm.models.entities.Movie;
import be.bstorm.models.forms.MovieForm;
import be.bstorm.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MovieDTO> create(@RequestBody MovieForm form){
        Movie createdMovie = movieService.create(form.toEntity());
        MovieDTO dto = MovieDTO.fromEntity(createdMovie);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
        Movie movie = movieService.findOne(id);
        MovieDTO dto = MovieDTO.fromEntity(movie);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<MovieShortDTO>> findAll(){
        List<Movie> movies = movieService.findAll();
        List<MovieShortDTO> dtos = movies.stream()
                .map(MovieShortDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieShortDTO>> search(@RequestParam String title){
        List<Movie> movies = movieService.searchByTitle(title);
        List<MovieShortDTO> dtos = movies.stream()
                .map(MovieShortDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MovieDTO> update(
            @PathVariable Long id,
            @RequestBody MovieForm form){
        Movie movie = movieService.update(id,form.toEntity());
        MovieDTO dto = MovieDTO.fromEntity(movie);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDTO> delete(@PathVariable Long id){
        Movie movie = movieService.delete(id);
        MovieDTO dto = MovieDTO.fromEntity(movie);
        return ResponseEntity.ok(dto);
    }
}
