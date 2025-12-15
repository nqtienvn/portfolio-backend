package com.tien.tai.portfoliobackend.repository;

import com.tien.tai.portfoliobackend.entity.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {
    List<WorkExperience> findByAuthorId(Long authorId);
}
