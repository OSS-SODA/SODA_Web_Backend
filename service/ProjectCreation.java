package com.soda.web.service;

import com.soda.web.domain.entity.Project;
import com.soda.web.repository.IProjectMemberRepository;
import com.soda.web.repository.IProjectRepository;
import org.springframework.transaction.annotation.Transactional;

public class ProjectCreation {
    private final IProjectRepository projectRepository;

    public ProjectCreation(IProjectRepository projectRepository, IProjectMemberRepository iProjectMemberRepository) {
        this.projectRepository = projectRepository;
        //projectMemberRepository는 필요없는데 domain.entity.project.addMember()가 있어서 우선은 인자로 추가함
        //추후 제거 가능
    }


    @Transactional
    public void create(Project project){
        projectRepository.registerProject(project);
    }
}
