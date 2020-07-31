package com.soda.web.repository;

import com.soda.web.domain.entity.ClubMember;
import com.soda.web.domain.entity.Project;

import javax.persistence.EntityManager;

public class ProjectMemberRepository implements IProjectMemberRepository{

    private final EntityManager em;

    public ProjectMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void registerParticipant(Project project, ClubMember clubMember) {

    }
}
