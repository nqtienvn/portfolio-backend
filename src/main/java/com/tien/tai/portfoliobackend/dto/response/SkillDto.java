package com.tien.tai.portfoliobackend.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SkillDto {
    private String name;
    private Integer experience;
    private List<TechStackDto> techStackList;
}
