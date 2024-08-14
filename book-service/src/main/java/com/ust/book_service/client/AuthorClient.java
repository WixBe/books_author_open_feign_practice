package com.ust.book_service.client;

import com.ust.book_service.dto.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "author-service")
public interface AuthorClient {

    @GetMapping("/api/v1/author/{id}")
    public Author getAuthorById(@PathVariable String id);
}
