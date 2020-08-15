package com.soda.web.repository;

import com.soda.web.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProjectRepository extends JpaRepository<Project,Long> {
    Optional<Project> findById(Long id);
}
