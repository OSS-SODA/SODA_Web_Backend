package com.soda.web.repository;

import com.soda.web.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * project name, id
 */
public interface IProjectRepository extends JpaRepository<Project,Long> {
//    public void registerProject(Project project);
//    public void registerRepo(String projectName,String url);
//    public void registerStatus(String projectName,int projectStatus);
//

    /**
     * 프로젝트 조회시 id로 조회
     * @param id
     * @return
     */
    Optional<Project> findById(Long id);
}
