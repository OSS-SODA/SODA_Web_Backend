package com.soda.web.repository;

import com.soda.web.domain.entity.ClubMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubMemberRepository extends JpaRepository<ClubMember,Long> {
    Optional<ClubMember> findByMemberId(String memberId);
}
