package com.tien.tai.portfoliobackend.service.impl;

import com.tien.tai.portfoliobackend.dto.response.AuthorProfileDto;
import com.tien.tai.portfoliobackend.dto.response.AvatarDto;
import com.tien.tai.portfoliobackend.dto.response.SkillDto;
import com.tien.tai.portfoliobackend.dto.response.SocialMediaDto;
import com.tien.tai.portfoliobackend.entity.Author;
import com.tien.tai.portfoliobackend.entity.Avatar;
import com.tien.tai.portfoliobackend.entity.Skill;
import com.tien.tai.portfoliobackend.entity.SocialMedia;
import com.tien.tai.portfoliobackend.repository.AuthorRepository;
import com.tien.tai.portfoliobackend.repository.AvatarRepository;
import com.tien.tai.portfoliobackend.repository.SkillRepository;
import com.tien.tai.portfoliobackend.repository.SocialMediaRepository;
import com.tien.tai.portfoliobackend.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final SocialMediaRepository socialMediaRepository;
    private final AvatarRepository avatarRepository;
    private final SkillRepository skillRepository;

    @Override
    @Transactional(readOnly = true)
    public AuthorProfileDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));

        List<SocialMedia> socialMediaList = socialMediaRepository.findByAuthorId(id);
        List<SocialMediaDto> socialMediaDtos = socialMediaList.stream()
                .map(this::mapToSocialMediaDto)
                .collect(Collectors.toList());

        List<Avatar> avatarList = avatarRepository.findByAuthorId(id);
        List<AvatarDto> avatarDtos = avatarList.stream()
                .map(this::mapToAvatarDto)
                .collect(Collectors.toList());

        List<Skill> skillList = skillRepository.findByAuthorId(id);
        List<SkillDto> skillDtos = skillList.stream()
                .map(this::mapToSkillDto)
                .collect(Collectors.toList());

        return AuthorProfileDto.builder()
                .id(author.getId())
                .name(author.getName())
                .phoneNumber(author.getPhoneNumber())
                .email(author.getEmail())
                .description(author.getDescription())
                .socialList(socialMediaDtos)
                .avatarList(avatarDtos)
                .skills(skillDtos)
                .build();
    }

    private SocialMediaDto mapToSocialMediaDto(SocialMedia socialMedia) {
        return SocialMediaDto.builder()
                .platform(socialMedia.getPlatform())
                .url(socialMedia.getUrl())
                .username(socialMedia.getUsername())
                .build();
    }

    private AvatarDto mapToAvatarDto(Avatar avatar) {
        return AvatarDto.builder()
                .name(avatar.getName())
                .build();
    }

    private SkillDto mapToSkillDto(Skill skill) {
        return SkillDto.builder()
                .name(skill.getName())
                .experience(skill.getExperience())
                .build();
    }
}
