package be.bstorm.services;

import be.bstorm.models.entities.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);
    Book getOne(Long id);
    List<Book> getAll();
    Book update(Long id,Book book);
    Book delete(Long id);
}
