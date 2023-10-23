package be.bstorm.models.forms;

import be.bstorm.models.entities.Book;
import lombok.Data;

@Data
public class BookForm {

    private String title;
    private String description;

    public Book toEntity(){
        Book book = new Book();
        book.setTitle(this.title);
        book.setDescription(this.description);
        return book;
    }
}
