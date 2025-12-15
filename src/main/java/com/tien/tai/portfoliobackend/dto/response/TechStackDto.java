package com.tien.tai.portfoliobackend.dto.response;

import com.tien.tai.portfoliobackend.entity.ExperienceLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TechStackDto {
    private Long id;
    private String name;
    private ExperienceLevel experience;
}
