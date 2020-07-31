package com.soda.web.repository;

import com.soda.web.domain.entity.Project;

import javax.persistence.EntityManager;

public class ProjectRepository implements IProjectRepository{
    private final EntityManager em;

    public ProjectRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void registerProject(Project project) {

    }

    @Override
    public void registerRepo(String projectName, String url) {

    }

    @Override
    public void registerStatus(String projectName, int projectStatus) {

    }
}
