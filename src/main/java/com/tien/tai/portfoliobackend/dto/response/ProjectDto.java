package com.tien.tai.portfoliobackend.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ProjectDto {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private String demoUrl;
    private String githubUrl;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<TechStackDto> techStackList;
}
