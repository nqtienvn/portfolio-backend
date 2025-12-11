package com.tien.tai.portfoliobackend.service;

import com.tien.tai.portfoliobackend.dto.response.AuthorProfileDto;

public interface AuthorService {
    AuthorProfileDto getAuthorById(Long id);
}
