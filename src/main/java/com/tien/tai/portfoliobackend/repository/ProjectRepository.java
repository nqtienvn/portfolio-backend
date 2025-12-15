package com.tien.tai.portfoliobackend.repository;

import com.tien.tai.portfoliobackend.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByAuthorId(Long authorId);
}
