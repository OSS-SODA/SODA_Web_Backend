package com.soda.web.security.utils;

import com.soda.web.domain.entity.ClubMember;
import com.soda.web.domain.entity.ClubMemberRole;
import com.soda.web.security.ClubMemberContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
class JwtUtilTest {

    JwtUtil jwtUtil;

    @BeforeEach
    public void setUp() {
        jwtUtil = new JwtUtil();
    }

    @Test
    void createToken() {
        ClubMember clubMember = ClubMember.builder()
                .memberId("naemoo")
                .memberPassword("123")
                .memberPermission(ClubMemberRole.USER)
                .build();

        String token = jwtUtil.createToken(ClubMemberContext.fromClubMember(clubMember));

        assertThat(token).contains("qwe");
    }

    @Test
    void getClaims() {
        String token = "eyJhbGciOiJIUzI1NiJ9" +
                ".eyJpc3MiOiJTT0RBIiwiaWF0IjoxNTk3MTYzNDQ0LCJVU0VSX0lEIjoibmFlbW9vIiwiVVNFUl9ST0xFIjoiVVNFUiJ9." +
                "3czOcQEHmiQjfvy4hJ632NZZ5-NDKRGv_A29E1Qxduo";
        ClubMemberContext clubMemberContext = jwtUtil.decodeJwt(token);

        assertThat(clubMemberContext.getUsername()).isEqualTo("naemoo");
        assertThat(clubMemberContext.getAuthorities().contains(new SimpleGrantedAuthority("USER")))
                .isTrue();
    }

}