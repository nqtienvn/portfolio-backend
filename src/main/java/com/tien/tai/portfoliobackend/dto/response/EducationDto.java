package com.tien.tai.portfoliobackend.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EducationDto {
    private Long id;
    private String schoolName;
    private String degree;
    private String major;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double gpa;
    private String achievements;
}
