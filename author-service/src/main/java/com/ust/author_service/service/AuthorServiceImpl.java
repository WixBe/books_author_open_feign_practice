package com.ust.author_service.service;

import com.ust.author_service.domain.Author;
import com.ust.author_service.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthor(String id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        if (authorRepository.findById(author.getId()).isPresent()) {
            return authorRepository.save(author);
        }
        return null;
    }

    @Override
    public void deleteAuthor(String id) {
        if (authorRepository.findById(id).isPresent()) {
            authorRepository.deleteById(id);
        } else {
            throw new RuntimeException("Author not found");
        }
    }
}
