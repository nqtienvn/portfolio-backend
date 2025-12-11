package com.tien.tai.portfoliobackend.repository;

import com.tien.tai.portfoliobackend.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    List<Avatar> findByAuthorId(Long authorId);
}
