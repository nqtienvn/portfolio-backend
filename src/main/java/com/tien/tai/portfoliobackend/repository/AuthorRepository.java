package com.tien.tai.portfoliobackend.repository;

import com.tien.tai.portfoliobackend.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
