package be.bstorm.models.dtos.book;

import be.bstorm.models.entities.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookShortDTO {

    private Long id;
    private String title;

    public BookShortDTO(Book book){
        this.id = book.getId();
        this.title = book.getTitle();
    }

    public static BookShortDTO fromEntity(Book b){
        BookShortDTO book = new BookShortDTO();
        book.setId(b.getId());
        book.setTitle(b.getTitle());
        return book;
    }
}
