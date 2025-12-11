package com.tien.tai.portfoliobackend.dto.response;

import com.tien.tai.portfoliobackend.entity.SocialPlatform;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SocialMediaDto {
    private SocialPlatform platform;
    private String url;
    private String username;
}
