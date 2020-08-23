package com.soda.web.security.tokens;

import com.soda.web.domain.entity.ClubMemberRole;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class JwtPostProcessingToken extends UsernamePasswordAuthenticationToken {
    private JwtPostProcessingToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public JwtPostProcessingToken(String userName, ClubMemberRole role){
        super(userName,"1234", parseAuthorities(role));
    }

    private static Collection<? extends GrantedAuthority> parseAuthorities(ClubMemberRole role) {
        return Arrays.asList(role).stream().map(r->new SimpleGrantedAuthority(r.getRole())).collect(Collectors.toList());
    }
}
