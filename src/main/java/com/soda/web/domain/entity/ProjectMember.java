package com.soda.web.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clubmember_id")
    private ClubMember clubMember;

    @Builder
    public ProjectMember(Project project, ClubMember clubMember) {
        this.project = project;
        this.clubMember = clubMember;
    }


}
