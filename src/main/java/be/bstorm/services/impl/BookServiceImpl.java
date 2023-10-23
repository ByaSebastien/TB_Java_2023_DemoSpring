package be.bstorm.services.impl;

import be.bstorm.models.entities.Book;
import be.bstorm.repositories.BookRepository;
import be.bstorm.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
