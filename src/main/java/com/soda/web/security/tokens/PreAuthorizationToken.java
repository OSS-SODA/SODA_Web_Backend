package com.soda.web.security.tokens;

import com.soda.web.dto.ClubMemberLoginDTO;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

//인증 전 토큰
public class PreAuthorizationToken extends UsernamePasswordAuthenticationToken {

    private PreAuthorizationToken(String userId, String password) {
        super(userId, password);
    }

    public PreAuthorizationToken(ClubMemberLoginDTO dto) {
        this(dto.getUserId(), dto.getPassword());
    }

    public String getUserId() {
        return (String) super.getPrincipal();
    }

    public String getPassword() {
        return (String) super.getCredentials();
    }
}
