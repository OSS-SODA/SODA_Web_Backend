package com.soda.web.dto;

import com.soda.web.domain.entity.ClubMember;
import com.soda.web.domain.entity.ClubMemberRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubMemberLoginDTO {
    private String userId;
    private String password;

    public ClubMemberLoginDTO(ClubMember clubMember){
        this.userId = clubMember.getMemberId();
        this.password = clubMember.getMemberPassword();
    }
}
