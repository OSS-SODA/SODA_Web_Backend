package com.soda.web.repository;

import com.soda.web.domain.entity.ClubMember;
import com.soda.web.domain.entity.Project;
import com.soda.web.domain.entity.ProjectMember;

public interface IProjectMemberRepository {
    public void registerParticipant(Project project,ClubMember clubMember);
}
