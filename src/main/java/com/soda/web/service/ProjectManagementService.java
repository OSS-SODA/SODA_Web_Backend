package com.soda.web.service;

import com.soda.web.domain.entity.ClubMember;
import com.soda.web.domain.entity.Project;
import com.soda.web.repository.IProjectMemberRepository;
import com.soda.web.repository.IProjectRepository;
import org.springframework.transaction.annotation.Transactional;

public class ProjectManagementService {
   private final IProjectRepository projectRepository;
   private final IProjectMemberRepository projectMemberRepository;


    public ProjectManagementService(IProjectRepository projectRepository, IProjectMemberRepository projectMemberRepository) {
        this.projectRepository = projectRepository;
        this.projectMemberRepository = projectMemberRepository;
    }

}
