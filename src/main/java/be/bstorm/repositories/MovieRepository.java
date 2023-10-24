package be.bstorm.repositories;

import be.bstorm.models.entities.Book;
import be.bstorm.models.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    boolean existsByTitle(String title);

    List<Movie> findMoviesByTitleContainingIgnoreCase(String title);

    @Query("select m from Movie m where m.title like %:title%")
    List<Movie> searchMoviesByTitle(@Param("title") String title);
}
