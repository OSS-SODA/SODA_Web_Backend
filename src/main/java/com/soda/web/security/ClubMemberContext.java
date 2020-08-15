package com.soda.web.security;

import com.soda.web.domain.entity.ClubMember;
import com.soda.web.domain.entity.ClubMemberRole;
import com.soda.web.repository.ClubMemberRepository;
import com.soda.web.security.tokens.JwtPostProcessingToken;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ClubMemberContext extends User {

    private ClubMember clubMember;

    private ClubMemberContext(ClubMember clubMember, String username,
                              String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.clubMember = clubMember;
    }

    public ClubMemberContext(String userId, String password, String role) {
        //실제 비밀번호가 아님
        super(userId, password, parseAuthorities(role));
    }

    public static ClubMemberContext fromClubMember(ClubMember clubMember) {
        return new ClubMemberContext(clubMember, clubMember.getMemberId(), clubMember.getMemberPassword(),
                parseAuthorities(clubMember.getMemberPermission()));
    }

    private static List<SimpleGrantedAuthority> parseAuthorities(ClubMemberRole clubMemberRole) {
        return Arrays.asList(clubMemberRole).stream().map(r -> new SimpleGrantedAuthority(String.valueOf(r.getRole())))
                .collect(Collectors.toList());
    }

    private static List<SimpleGrantedAuthority> parseAuthorities(String role) {
        return parseAuthorities(ClubMemberRole.getRoleByName(role));
    }

    public ClubMember getClubMember() {
        return clubMember;
    }
}
