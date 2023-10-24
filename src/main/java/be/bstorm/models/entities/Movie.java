package be.bstorm.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false,length = 100)
    private String title;

    private String description;
}
