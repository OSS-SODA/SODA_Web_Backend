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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String userId;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private int permission;

    @OneToMany(mappedBy = "user")
    private List<ProjectMember> projectList = new ArrayList<ProjectMember>();

    @Builder
    public User(String name, String userId, String password, int permission) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.permission = permission;
    }
}
