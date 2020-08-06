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
public class ClubMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String memberName; //

    @Column(nullable=false)
    private String memberId;

    @Column(nullable=false)
    private String memberPassword;

    @Column(nullable=false)
    private int memberPermission;

    @OneToMany(mappedBy = "clubmember")
    private List<ProjectMember> projectList = new ArrayList<ProjectMember>();

    @Builder
    public ClubMember(String memberName, String memberId, String memberPassword, int memberPermission) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberPermission = memberPermission;
    }

    public ClubMember addProject(ProjectMember projectMember) {
        this.projectList.add(projectMember);
        return this;
    }


}
