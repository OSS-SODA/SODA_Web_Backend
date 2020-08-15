package com.soda.web.security.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soda.web.dto.TokenDto;
import com.soda.web.security.ClubMemberContext;
import com.soda.web.security.tokens.PostAuthorizationToken;
import com.soda.web.security.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FormLoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth) throws IOException, ServletException {
        PostAuthorizationToken token = (PostAuthorizationToken) auth;
        ClubMemberContext context = (ClubMemberContext) token.getPrincipal();

        String jwtToken = jwtUtil.createToken(context);

        processResponse(res,writeDto(jwtToken));
    }

    private TokenDto writeDto(String token) {
        return new TokenDto(token);
    }

    private void processResponse(HttpServletResponse res, TokenDto dto) throws IOException {
        res.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        res.setStatus(HttpStatus.OK.value());
        res.getWriter().write(objectMapper.writeValueAsString(dto));
    }
}
