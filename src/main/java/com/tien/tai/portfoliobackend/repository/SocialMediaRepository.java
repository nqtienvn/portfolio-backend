package com.tien.tai.portfoliobackend.repository;

import com.tien.tai.portfoliobackend.entity.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long> {
    List<SocialMedia> findByAuthorId(Long authorId);
}
