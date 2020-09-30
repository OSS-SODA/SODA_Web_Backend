package com.soda.web.repository;

import com.soda.web.domain.entity.ClubMember;
import com.soda.web.domain.entity.Project;
import com.soda.web.domain.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectMemberRepository extends JpaRepository<Project,Long> {

}
