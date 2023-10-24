package be.bstorm.models.forms;

import be.bstorm.models.entities.Movie;
import lombok.Data;

@Data
public class MovieForm {

    private String title;
    private String description;

    public Movie toEntity(){
        Movie movie = new Movie();
        movie.setTitle(this.title);
        movie.setDescription(this.description);
        return movie;
    }
}
