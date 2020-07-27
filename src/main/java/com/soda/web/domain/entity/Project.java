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
    private String name;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private String idea;

    @Column
    private String repository_address;

    @Column
    private String description;

    @OneToMany(mappedBy = "project")
    private List<ProjectMember> memberList = new ArrayList<ProjectMember>();

    @Builder
    public Project(String name, int status, String idea, String repository_address, String description) {
        this.name = name;
        this.status = status;
        this.idea = idea;
        this.repository_address = repository_address;
        this.description = description;
    }
}
