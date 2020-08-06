package com.soda.web;


/**
* 프로젝트 생성, 제거 수정 요청

 */

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModifyProjectRequest {
    /**
    프로젝트 명
     */
    private String projectName;
    /**
     * 프로젝트 진행상태
     */
    private int projectStatus;
    /**
     * 프로젝트 아이디어
     */
    private String projectIdea;
    /**
     * 프로젝트 레포지토리 url
     */
    private String projectRepository;
    /**
     * 프로젝트 상세내용
     */
    private String projectContent;
}
