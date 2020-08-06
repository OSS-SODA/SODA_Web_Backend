package com.soda.web.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String projectName;

    @Column(nullable = false)
    private int projectStatus;

    @Column(nullable = false)
    private String projectIdea;

    @Column
    private String projectRepository;

    @Column
    private String projectContent;

    @OneToMany(mappedBy = "project")
    private List<ProjectMember> memberList = new ArrayList<ProjectMember>();

    @Builder
    public Project(String projectName, int projectStatus, String projectIdea, String projectRepository, String projectContent) {

        this.projectName = projectName;
        this.projectStatus = projectStatus;
        this.projectIdea = projectIdea;
        this.projectRepository = projectRepository;
        this.projectContent = projectContent;
    }
//    @Builder
//    public Project(Long id,String projectName, int projectStatus, String projectIdea, String projectRepository, String projectContent) {
//        this.id=id;
//        this.projectName = projectName;
//        this.projectStatus = projectStatus;
//        this.projectIdea = projectIdea;
//        this.projectRepository = projectRepository;
//        this.projectContent = projectContent;
//    }

    public Project addMember(ProjectMember projectMember) {
        this.memberList.add(projectMember);
        return this;
    }

    /**
     *
     * @param projectName
     * @param projectStatus
     * @param projectIdea
     * @param projectRepository
     * @param projectContent
     * 프로젝트 수정
     */
    public void updateProject(String projectName,int projectStatus, String projectIdea, String projectRepository,String projectContent){
        this.projectName=projectName;
        this.projectStatus=projectStatus;
        this.projectIdea=projectIdea;
        this.projectRepository=projectRepository;
        this.projectContent=projectContent;
    }

}
