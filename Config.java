package com.soda.web;

import com.soda.web.repository.IProjectMemberRepository;
import com.soda.web.repository.IProjectRepository;
import com.soda.web.repository.ProjectMemberRepository;
import com.soda.web.repository.ProjectRepository;
import com.soda.web.service.ProjectCreation;
import com.soda.web.service.ProjectManagement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class Config {


    private final DataSource dataSource;
    private final EntityManager em;

    public Config(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public ProjectCreation projectCreation(){
        return new ProjectCreation(projectRepository(),projectMemberRepository());
    }
    @Bean
    public ProjectManagement projectManagement(){
        return new ProjectManagement(projectRepository(),projectMemberRepository());
    }
    @Bean
    public IProjectRepository projectRepository(){
        return new ProjectRepository(em);
    }
    @Bean
    public IProjectMemberRepository projectMemberRepository(){
        return new ProjectMemberRepository(em);
    }

}
