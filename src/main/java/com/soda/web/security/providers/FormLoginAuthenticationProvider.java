package com.soda.web.security.providers;

import com.soda.web.domain.entity.ClubMember;
import com.soda.web.repository.ClubMemberRepository;
import com.soda.web.security.ClubMemberContext;
import com.soda.web.security.tokens.PostAuthorizationToken;
import com.soda.web.security.tokens.PreAuthorizationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class FormLoginAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private ClubMemberRepository clubMemberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        PreAuthorizationToken token = (PreAuthorizationToken) authentication;

        String userId = token.getUserId();
        String password = token.getPassword();

        ClubMember clubMember = clubMemberRepository.findByMemberId(userId)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 사용자 입니다."));

        if (isCorrectPassword(password, clubMember)) {
            return PostAuthorizationToken
                    .getTokenFromClubMemberContext(ClubMemberContext.fromClubMember(clubMember));
        }
        throw new NoSuchElementException("인증 정보가 정확하지 않습니다.");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return PreAuthorizationToken.class.isAssignableFrom(aClass);
    }

    private boolean isCorrectPassword(String password, ClubMember clubMember) {
        return passwordEncoder.matches(password, clubMember.getMemberPassword());
    }
}
