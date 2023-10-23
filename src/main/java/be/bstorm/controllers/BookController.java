package be.bstorm.controllers;

import be.bstorm.models.entities.Book;
import be.bstorm.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book){
        Book createBook = bookService.create(book);
        return ResponseEntity.ok(createBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id){
        Book book = bookService.getOne(id);
        return ResponseEntity.ok(book);
    }
}
