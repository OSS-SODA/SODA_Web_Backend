package com.soda.web.service;

import com.soda.web.domain.entity.ClubMember;
import com.soda.web.domain.entity.Project;
import com.soda.web.repository.IProjectMemberRepository;
import com.soda.web.repository.IProjectRepository;
import org.springframework.transaction.annotation.Transactional;

public class ProjectManagement {
   private final IProjectRepository projectRepository;
   private final IProjectMemberRepository projectMemberRepository;


    public ProjectManagement(IProjectRepository projectRepository, IProjectMemberRepository projectMemberRepository) {
        this.projectRepository = projectRepository;
        this.projectMemberRepository = projectMemberRepository;
    }

    //레포 등록
    @Transactional
    public void registerRepo(String projectName, String url)
    {
        projectRepository.registerRepo(projectName,url);
    }
    //참여자 등록
    @Transactional
    public void registerProjectMember(Project project,ClubMember clubMember){
        projectMemberRepository.registerParticipant(project, clubMember);
    }
    //domain.entity.ProjectMember의 생성자에 맞춰 project, clubMember를 파라미터로 사용

    //프로젝트 상태 등록
    @Transactional
    public void registerProjectStatus(String projectName,int status){
        projectRepository.registerStatus(projectName,status);
    }
}
