package com.soda.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProjectDto {
    private String id;
    private String projectName;
    private int projectStatus;
    private String projectIdea;
    private String projectRepository;
    private String projectContent;
    @Builder
    public ProjectDto(String id, String projectName, int projectStatus, String projectIdea, String projectRepository, String projectContent) {
        this.id = id;
        this.projectName = projectName;
        this.projectStatus = projectStatus;
        this.projectIdea = projectIdea;
        this.projectRepository = projectRepository;
        this.projectContent = projectContent;
    }



}
