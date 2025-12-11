package com.tien.tai.portfoliobackend.service;


import com.tien.tai.portfoliobackend.dto.response.SkillDto;

import java.util.List;

public interface SkillService {
    List<SkillDto> getSkillByAuthorId(Long id);

}
