package com.soda.web.security.providers;

import com.soda.web.security.ClubMemberContext;
import com.soda.web.security.tokens.JwtPreProcessingToken;
import com.soda.web.security.tokens.PostAuthorizationToken;
import com.soda.web.security.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = (String) authentication.getPrincipal();
        ClubMemberContext context = jwtUtil.decodeJwt(token);

        return PostAuthorizationToken.getTokenFromClubMemberContext(context);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return JwtPreProcessingToken.class.isAssignableFrom(aClass);
    }
}
