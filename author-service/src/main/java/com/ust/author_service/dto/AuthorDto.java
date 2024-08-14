package com.ust.author_service.dto;

import com.ust.author_service.domain.Author;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record AuthorDto(
        String id,

        @NotEmpty(message = "Name is required!")
        @Pattern(regexp = "^[^0-9]*$")
        String name
) {

    public AuthorDto fromAuthor(Author author) {
        return new AuthorDto(
                author.getId(),
                author.getName()
        );
    }

    public  Author toAuthor(AuthorDto dto) {
        return new Author(
                dto.id,
                dto.name
        );
    }
}
