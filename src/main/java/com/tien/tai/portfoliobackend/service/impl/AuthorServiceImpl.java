package com.tien.tai.portfoliobackend.service.impl;

import com.tien.tai.portfoliobackend.dto.response.AuthorProfileDto;
import com.tien.tai.portfoliobackend.dto.response.AvatarDto;
import com.tien.tai.portfoliobackend.dto.response.EducationDto;
import com.tien.tai.portfoliobackend.dto.response.SkillDto;
import com.tien.tai.portfoliobackend.dto.response.TechStackDto;
import com.tien.tai.portfoliobackend.dto.response.SocialMediaDto;
import com.tien.tai.portfoliobackend.dto.response.WorkExperienceDto;
import com.tien.tai.portfoliobackend.dto.response.ProjectDto;
import com.tien.tai.portfoliobackend.entity.Author;
import com.tien.tai.portfoliobackend.entity.Avatar;
import com.tien.tai.portfoliobackend.entity.Education;
import com.tien.tai.portfoliobackend.entity.Skill;
import com.tien.tai.portfoliobackend.entity.SocialMedia;
import com.tien.tai.portfoliobackend.entity.TechStack;
import com.tien.tai.portfoliobackend.entity.WorkExperience;
import com.tien.tai.portfoliobackend.entity.Project;
import com.tien.tai.portfoliobackend.entity.ProjectTechStack;
import com.tien.tai.portfoliobackend.repository.AuthorRepository;
import com.tien.tai.portfoliobackend.repository.AvatarRepository;
import com.tien.tai.portfoliobackend.repository.EducationRepository;
import com.tien.tai.portfoliobackend.repository.SkillRepository;
import com.tien.tai.portfoliobackend.repository.SocialMediaRepository;
import com.tien.tai.portfoliobackend.repository.TechStackRepository;
import com.tien.tai.portfoliobackend.repository.WorkExperienceRepository;
import com.tien.tai.portfoliobackend.repository.ProjectRepository;
import com.tien.tai.portfoliobackend.repository.ProjectTechStackRepository;
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
        private final EducationRepository educationRepository;
        private final TechStackRepository techStackRepository;
        private final WorkExperienceRepository workExperienceRepository;
        private final ProjectRepository projectRepository;
        private final ProjectTechStackRepository projectTechStackRepository;

        @Override
        @Transactional(readOnly = true)
        public AuthorProfileDto getAuthorById(Long id) {
                Author author = authorRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));

                List<SocialMedia> socialMediaList = socialMediaRepository.findByAuthorId(id);
                List<SocialMediaDto> socialMediaDtos = socialMediaList.stream()
                                .map(this::mapToSocialMediaDto)
                                .collect(Collectors.toList());
                List<Education> educationList = educationRepository.findByAuthorId(id);
                List<EducationDto> educationDtos = educationList.stream()
                                .map(this::mapToEducationDto)
                                .collect(Collectors.toList());
                List<Avatar> avatarList = avatarRepository.findByAuthorId(id);
                List<AvatarDto> avatarDtos = avatarList.stream()
                                .map(this::mapToAvatarDto)
                                .collect(Collectors.toList());

                List<Skill> skillList = skillRepository.findByAuthorId(id);
                List<SkillDto> skillDtos = skillList.stream()
                                .map(this::mapToSkillDto)
                                .collect(Collectors.toList());

                List<WorkExperience> workExperienceList = workExperienceRepository.findByAuthorId(id);
                List<WorkExperienceDto> workExperienceDtos = workExperienceList.stream()
                                .map(this::mapToWorkExperienceDto)
                                .collect(Collectors.toList());

                List<Project> projectList = projectRepository.findByAuthorId(id);
                List<ProjectDto> projectDtos = projectList.stream()
                                .map(this::mapToProjectDto)
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
                                .educationList(educationDtos)
                                .workExperienceList(workExperienceDtos)
                                .projectList(projectDtos)
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
                List<TechStack> techStackList = techStackRepository.findBySkillId(skill.getId());
                List<TechStackDto> techStackDtos = techStackList.stream()
                                .map(this::mapToTechStackDto)
                                .collect(Collectors.toList());

                return SkillDto.builder()
                                .name(skill.getName())
                                .experience(skill.getExperience())
                                .techStackList(techStackDtos)
                                .build();
        }

        private TechStackDto mapToTechStackDto(TechStack techStack) {
                return TechStackDto.builder()
                                .id(techStack.getId())
                                .name(techStack.getName())
                                .experience(techStack.getExperience())
                                .build();
        }

        private EducationDto mapToEducationDto(Education education) {
                return EducationDto.builder()
                                .id(education.getId())
                                .schoolName(education.getSchoolName())
                                .degree(education.getDegree())
                                .major(education.getMajor())
                                .startDate(education.getStartDate())
                                .endDate(education.getEndDate())
                                .gpa(education.getGpa())
                                .achievements(education.getAchievements())
                                .build();
        }

        private WorkExperienceDto mapToWorkExperienceDto(WorkExperience workExperience) {
                return WorkExperienceDto.builder()
                                .id(workExperience.getId())
                                .companyName(workExperience.getCompanyName())
                                .position(workExperience.getPosition())
                                .startDate(workExperience.getStartDate())
                                .endDate(workExperience.getEndDate())
                                .isCurrent(workExperience.getIsCurrent())
                                .description(workExperience.getDescription())
                                .achievements(workExperience.getAchievements())
                                .build();
        }

        private ProjectDto mapToProjectDto(Project project) {
                // Get tech stack IDs from junction table
                List<ProjectTechStack> projectTechStacks = projectTechStackRepository.findByProjectId(project.getId());

                // Load full TechStack entities and map to DTOs
                List<TechStackDto> techStackDtos = projectTechStacks.stream()
                                .map(pts -> techStackRepository.findById(pts.getTechStackId()).orElse(null))
                                .filter(ts -> ts != null)
                                .map(this::mapToTechStackDto)
                                .collect(Collectors.toList());

                return ProjectDto.builder()
                                .id(project.getId())
                                .name(project.getName())
                                .description(project.getDescription())
                                .imageUrl(project.getImageUrl())
                                .demoUrl(project.getDemoUrl())
                                .githubUrl(project.getGithubUrl())
                                .startDate(project.getStartDate())
                                .endDate(project.getEndDate())
                                .techStackList(techStackDtos)
                                .build();
        }
}
