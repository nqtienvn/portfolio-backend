package com.tien.tai.portfoliobackend.service;

import com.tien.tai.portfoliobackend.dto.response.AvatarDto;

import java.util.List;

public interface AvatarService {
    List<AvatarDto> getAvatarByAuthorId(Long id);

}
