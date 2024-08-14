package com.ust.book_service.controller;

import com.ust.book_service.client.AuthorClient;
import com.ust.book_service.domain.Book;
import com.ust.book_service.dto.Author;
import com.ust.book_service.dto.BookDto;
import com.ust.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService, AuthorClient authorClient) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok().body(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id) {
        return ResponseEntity.ok().body(bookService.getBook(id));
    }

    @GetMapping("/{id}/check")
    public ResponseEntity<Author> getAuthor(@PathVariable String id) {
        return ResponseEntity.ok().body(bookService.getAuthorById(id));
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto dto) {
        Book book = dto.toBook(dto);
        book = bookService.createBook(book);
        dto = dto.fromBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto dto) {
        Book book = dto.toBook(dto);
        bookService.updateBook(book);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBook(String id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().body(null);
    }
}
