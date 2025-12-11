package com.tien.tai.portfoliobackend.controller;

import com.tien.tai.portfoliobackend.dto.response.AuthorProfileDto;
import com.tien.tai.portfoliobackend.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/portfolio")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    private final AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<AuthorProfileDto> findProfileById(@PathVariable Long id) {
        AuthorProfileDto authorProfile = authorService.getAuthorById(id);
        return ResponseEntity.ok(authorProfile);
    }
}
