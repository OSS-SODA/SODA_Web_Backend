package com.soda.web.security;

import com.soda.web.domain.entity.ClubMember;
import com.soda.web.repository.ClubMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

public class ClubMemberContextService implements UserDetailsService {
    @Autowired
    private ClubMemberRepository clubMemberRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        ClubMember clubMember = clubMemberRepository.findByMemberId(userId).orElseThrow(NoSuchElementException::new);
        return getClubMemberContext(clubMember);
    }

    private UserDetails getClubMemberContext(ClubMember clubMember){
        return ClubMemberContext.fromClubMember(clubMember);
    }
}
