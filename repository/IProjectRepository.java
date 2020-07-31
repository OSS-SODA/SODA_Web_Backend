package com.soda.web.repository;

import com.soda.web.domain.entity.Project;

public interface IProjectRepository {
    public void registerProject(Project project);
    public void registerRepo(String projectName,String url);
    public void registerStatus(String projectName,int projectStatus);
}
