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
    private String projectName;
    private int projectStatus;
    private String projectIdea;
    private String projectRepository;
    private String projectContent;
}
