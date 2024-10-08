package com.ust.book_service.dto;

import com.ust.book_service.domain.Book;
import jakarta.validation.constraints.NotEmpty;

public record BookDto(
        String id,

        @NotEmpty(message = "Title is required")
        String title,

        @NotEmpty(message = "Author ID IS required")
        String authorId
) {

    public BookDto fromBook(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthorId()
        );
    }

    public Book toBook(BookDto dto) {
        return new Book(
                dto.id,
                dto.title,
                dto.authorId
        );
    }
}
