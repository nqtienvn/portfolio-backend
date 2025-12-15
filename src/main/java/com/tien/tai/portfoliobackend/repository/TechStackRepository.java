package com.tien.tai.portfoliobackend.repository;

import com.tien.tai.portfoliobackend.entity.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechStackRepository extends JpaRepository<TechStack, Long> {
    List<TechStack> findBySkillId(Long skillId);
}
