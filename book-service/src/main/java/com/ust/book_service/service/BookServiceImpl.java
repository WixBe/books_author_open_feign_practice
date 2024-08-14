package com.ust.book_service.service;

import com.ust.book_service.client.AuthorClient;
import com.ust.book_service.domain.Book;
import com.ust.book_service.dto.Author;
import com.ust.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorClient authorClient;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        if (bookRepository.findById(book.getId()).isPresent()) {
            return bookRepository.save(book);
        } else {
            throw new RuntimeException("Book not found");
        }
    }

    @Override
    public void deleteBook(String id) {
        if(bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Book not found");
        }
    }

    @Override
    public Author getAuthorById(String id) {
        return authorClient.getAuthorById(id);
    }
}
