package com.soda.web.repository;

import com.soda.web.domain.entity.ClubMember;
import com.soda.web.domain.entity.ClubMemberRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
class ClubMemberRepositoryTest {
    @Autowired
    private ClubMemberRepository clubMemberRepository;

    @Test
    void create(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        ClubMember clubMember = ClubMember.builder()
                .memberName("nam")
                .memberId("testid")
                .memberPassword(encoder.encode("123"))
                .memberPermission(ClubMemberRole.USER)
                .build();

        ClubMember newClubMember = clubMemberRepository.save(clubMember);

        assertAll(
                ()->assertThat(newClubMember.getMemberName()).isEqualTo("nam"),
                ()->assertThat(newClubMember.getMemberId()).isEqualTo("testid"),
                ()->assertThat(encoder.matches("123",newClubMember.getMemberPassword())).isTrue(),
                ()->assertThat(newClubMember.getMemberPermission()).isEqualTo(ClubMemberRole.USER)
        );
    }

    @Test
    void findByMemberId(){
        Optional<ClubMember> clubMember = clubMemberRepository.findByMemberId("test");
        clubMember.ifPresent(cm->{
            assertThat(cm.getMemberName()).isEqualTo("naemoo");
        });
    }

    @Test
    void deleteMemberId(){
        clubMemberRepository.deleteAll();
    }

}