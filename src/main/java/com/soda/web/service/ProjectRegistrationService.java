package com.soda.web.service;

import com.soda.web.ModifyProjectRequest;
import com.soda.web.domain.entity.Project;
import com.soda.web.dto.ProjectDto;
import com.soda.web.exception.AccessDenyException;
import com.soda.web.exception.ProjectNotFoundException;
import com.soda.web.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class ProjectRegistrationService {
    private final ProjectRepository projectRepository;




    @Transactional
    public Long saveProject(Long pid, ModifyProjectRequest modifyProjectRequest){
        Project newProject=Project.builder()
                .projectName(modifyProjectRequest.getProjectName())
                .projectStatus(modifyProjectRequest.getProjectStatus())
                .projectIdea(modifyProjectRequest.getProjectIdea())
                .projectRepository(modifyProjectRequest.getProjectRepository())
                .projectContent(modifyProjectRequest.getProjectContent())
                .build();

        return this.projectRepository.save(newProject).getId();

    }


    @Transactional
    public ProjectDto getProject(Long id){
        Project project = this.projectRepository.findById(id)
                .orElseThrow(ProjectNotFoundException::new);

        return ProjectDto.builder()
                .projectName(project.getProjectName())
                .projectStatus(project.getProjectStatus())
                .projectIdea(project.getProjectIdea())
                .projectRepository(project.getProjectRepository())
                .projectContent(project.getProjectContent())
                .build();

    }

    @Transactional
    public void modifyProject(Long id, ModifyProjectRequest modifyProjectRequest){
        permissionCheck(id)
                .updateProject(modifyProjectRequest.getProjectName(),
                        modifyProjectRequest.getProjectStatus(),
                        modifyProjectRequest.getProjectIdea(),
                        modifyProjectRequest.getProjectRepository(),
                        modifyProjectRequest.getProjectContent());

    }


    @Transactional
    public void deleteProject(Long id){
        this.projectRepository.deleteById(permissionCheck(id).getId());
    }

    private Project permissionCheck(Long id){
        Project project=this.projectRepository.findById(id)
                .orElseThrow(ProjectNotFoundException::new);
        if(!SecurityContextHolder.getContext().getAuthentication().getName().equals(project.getId()))
            throw new AccessDenyException();
        return project;
    }
}
