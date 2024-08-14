package com.ust.book_service.service;

import com.ust.book_service.domain.Book;
import com.ust.book_service.dto.Author;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();

    Book getBook(String id);

    Book createBook(Book book);

    Book updateBook(Book book);

    void deleteBook(String id);

    Author getAuthorById(String id);
}
