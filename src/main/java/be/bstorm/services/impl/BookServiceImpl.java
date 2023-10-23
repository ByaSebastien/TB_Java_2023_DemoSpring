package be.bstorm.services.impl;

import be.bstorm.models.entities.Book;
import be.bstorm.repositories.BookRepository;
import be.bstorm.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getOne(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book update(Long id, Book book) {
        Book existingBook = getOne(id);
        existingBook.setTitle(book.getTitle());
        existingBook.setDescription(book.getDescription());
        return bookRepository.save(existingBook);
    }

    @Override
    public Book delete(Long id) {
        Book existingBook = getOne(id);
        bookRepository.delete(existingBook);
        return existingBook;
    }
}
