package com.ust.author_service.controller;

import com.ust.author_service.domain.Author;
import com.ust.author_service.dto.AuthorDto;
import com.ust.author_service.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok().body(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable String id) {
        return ResponseEntity.ok().body(authorService.getAuthor(id));
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto dto) {
        Author author = dto.toAuthor(dto);
        author = authorService.createAuthor(author);
        dto = dto.fromAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthor(@RequestBody AuthorDto dto) {
        Author author = dto.toAuthor(dto);
        authorService.updateAuthor(author);
        return ResponseEntity.ok().body(dto);
    }
}
