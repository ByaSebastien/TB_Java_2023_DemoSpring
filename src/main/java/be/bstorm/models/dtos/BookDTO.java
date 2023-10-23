package be.bstorm.models.dtos;

import be.bstorm.models.entities.Book;
import lombok.Data;

@Data
public class BookDTO {

    private Long id;
    private String title;
    private String description;

    public static BookDTO fromEntity(Book book){
        BookDTO b = new BookDTO();
        b.setId(book.getId());
        b.setTitle(book.getTitle());
        b.setDescription(book.getDescription());
        return b;
    }
}
