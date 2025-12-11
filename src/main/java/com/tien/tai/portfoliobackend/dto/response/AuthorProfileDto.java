package com.tien.tai.portfoliobackend.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AuthorProfileDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String description;
    private List<SocialMediaDto> socialList;
    private List<AvatarDto> avatarList;
    private List<SkillDto> skills;
}
