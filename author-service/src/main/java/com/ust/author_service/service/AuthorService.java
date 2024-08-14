package com.ust.author_service.service;

import com.ust.author_service.domain.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author getAuthor(String id);

    Author createAuthor(Author author);

    Author updateAuthor(Author author);

    void deleteAuthor(String id);
}
