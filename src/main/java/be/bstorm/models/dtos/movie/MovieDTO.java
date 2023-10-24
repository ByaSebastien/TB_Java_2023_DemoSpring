package be.bstorm.models.dtos.movie;

import be.bstorm.models.entities.Movie;
import lombok.Data;

@Data
public class MovieDTO {

    private Long id;
    private String title;
    private String description;

    public static MovieDTO fromEntity(Movie movie){
        MovieDTO m = new MovieDTO();
        m.setId(movie.getId());
        m.setTitle(movie.getTitle());
        m.setDescription(movie.getDescription());
        return m;
    }
}
