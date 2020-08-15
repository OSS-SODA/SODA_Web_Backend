package com.soda.web;

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
