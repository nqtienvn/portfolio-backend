package com.tien.tai.portfoliobackend.repository;

import com.tien.tai.portfoliobackend.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findByAuthorId(Long authorId);
}
