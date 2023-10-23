package be.bstorm.controllers;

import be.bstorm.models.dtos.BookDTO;
import be.bstorm.models.dtos.BookShortDTO;
import be.bstorm.models.entities.Book;
import be.bstorm.models.forms.BookForm;
import be.bstorm.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDTO> create(@RequestBody BookForm book) {
        Book createdBook = bookService.create(book.toEntity());
//        BookShortDTO dto = new BookShortDTO(createdBook);
        BookDTO dto = BookDTO.fromEntity(createdBook);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findOneById(@PathVariable Long id) {
        Book book = bookService.getOne(id);
        BookDTO bookDTO = BookDTO.fromEntity(book);
        return ResponseEntity.ok(bookDTO);
    }

    @GetMapping
    public ResponseEntity<List<BookShortDTO>> findAll(){
        List<Book> books = bookService.getAll();
        List<BookShortDTO> dtos = books.stream()
                .map(BookShortDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookDTO> update(@PathVariable Long id,@RequestBody BookForm book){
        Book updatedBook = bookService.update(id,book.toEntity());
        BookDTO dto = BookDTO.fromEntity(updatedBook);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> delete(@PathVariable Long id){
        Book deletedBook = bookService.delete(id);
        BookDTO dto = BookDTO.fromEntity(deletedBook);
        return ResponseEntity.ok(dto);
    }
}