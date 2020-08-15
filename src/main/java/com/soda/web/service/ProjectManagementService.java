package com.soda.web.service;

import com.soda.web.repository.ProjectMemberRepository;
import com.soda.web.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectManagementService {
   private final ProjectRepository projectRepository;
   private final ProjectMemberRepository projectMemberRepository;


}
