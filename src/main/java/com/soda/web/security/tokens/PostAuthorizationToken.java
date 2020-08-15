package com.soda.web.security.tokens;

import com.soda.web.security.ClubMemberContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

//인증 후 토큰
public class PostAuthorizationToken extends UsernamePasswordAuthenticationToken {

    private PostAuthorizationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public static PostAuthorizationToken getTokenFromClubMemberContext(ClubMemberContext context){
        return new PostAuthorizationToken(context,context.getPassword(),context.getAuthorities());
    }

}
