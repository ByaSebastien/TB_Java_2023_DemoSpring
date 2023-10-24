package be.bstorm.models.dtos.movie;

import be.bstorm.models.entities.Movie;
import lombok.Data;

@Data
public class MovieShortDTO {

    private Long id;
    private String title;

    public static MovieShortDTO fromEntity(Movie movie){
        MovieShortDTO m = new MovieShortDTO();
        m.setId(movie.getId());
        m.setTitle(movie.getTitle());
        return m;
    }
}
