package com.ust.client;

import com.ust.dto.Author;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "author-service", url = "http://localhost:8100/api/v1/author")
public interface AuthorClient {

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable String id);
}
