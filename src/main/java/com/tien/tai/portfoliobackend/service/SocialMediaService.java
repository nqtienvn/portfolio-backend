package com.tien.tai.portfoliobackend.service;

import com.tien.tai.portfoliobackend.dto.response.SocialMediaDto;

import java.util.List;

public interface SocialMediaService {
    List<SocialMediaDto> getSocialMediaByAuthorId(Long id);

}
