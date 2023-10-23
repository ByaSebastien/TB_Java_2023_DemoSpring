package be.bstorm.services;

import be.bstorm.models.entities.Book;

public interface BookService {

    Book create(Book book);
    Book getOne(Long id);
}
