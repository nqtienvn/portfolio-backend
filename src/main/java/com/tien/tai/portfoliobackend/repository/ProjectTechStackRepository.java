package com.tien.tai.portfoliobackend.repository;

import com.tien.tai.portfoliobackend.entity.ProjectTechStack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectTechStackRepository extends JpaRepository<ProjectTechStack, Long> {
    List<ProjectTechStack> findByProjectId(Long projectId);
}
