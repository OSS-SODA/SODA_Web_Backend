package com.soda.web.service;

import com.soda.web.ModifyProjectRequest;
import com.soda.web.domain.entity.Project;
import com.soda.web.dto.ProjectDto;
import com.soda.web.exception.AccessDenyException;
import com.soda.web.exception.ProjectNotFoundException;
import com.soda.web.repository.IProjectMemberRepository;
import com.soda.web.repository.IProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class ProjectRegistrationService {
    private final IProjectRepository projectRepository;

    public ProjectRegistrationService(IProjectRepository projectRepository) {
        this.projectRepository = projectRepository;

    }

    /**
     * 프로젝트 생성
     * @param modifyProjectRequest
     * @return 프로젝트 작성자
     */
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

    /**
     * 프로젝트 조회
     */
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
    /**
     * 프로젝트 수정
     */
    @Transactional
    public void modifyProject(Long id, ModifyProjectRequest modifyProjectRequest){
        permissionCheck(id)
                .updateProject(modifyProjectRequest.getProjectName(),
                        modifyProjectRequest.getProjectStatus(),
                        modifyProjectRequest.getProjectIdea(),
                        modifyProjectRequest.getProjectRepository(),
                        modifyProjectRequest.getProjectContent());

    }

    /**
     * 프로젝트 삭제
     */
    @Transactional
    public void deleteProject(Long id){
        this.projectRepository.deleteById(permissionCheck(id).getId());
    }
    /**
     * 프로젝트 수정 권한 확인
     *
     */
    private Project permissionCheck(Long id){
        Project project=this.projectRepository.findById(id)
                .orElseThrow(ProjectNotFoundException::new);
        if(!SecurityContextHolder.getContext().getAuthentication().getName().equals(project.getId()))
            throw new AccessDenyException();
        return project;
    }
}
