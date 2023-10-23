package be.bstorm.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String title;

    private String description;
}
