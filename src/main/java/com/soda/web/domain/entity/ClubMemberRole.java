package com.soda.web.domain.entity;

import lombok.Getter;

import java.util.Arrays;
import java.util.NoSuchElementException;

@Getter
public enum ClubMemberRole {
    ADMIN("ROLE_ADMIN"),USER("ROLE_USER");

    private String role;

    ClubMemberRole(String role) {
        this.role = role;
    }

    public boolean isCorrectName(String name){
        return name.equalsIgnoreCase(this.role);
    }

    public static ClubMemberRole getRoleByName(String roleName){
        return Arrays.stream(ClubMemberRole.values()).filter(r-> r.isCorrectName(roleName))
                .findFirst().orElseThrow(()->new NoSuchElementException("검색된 권한이 없습니다."));
    }

}
