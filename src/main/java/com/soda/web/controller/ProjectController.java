package com.soda.web.controller;

import com.soda.web.domain.entity.Project;
import com.soda.web.request.CreateProjectRequest;
import com.soda.web.request.ModifyProjectRequest;
import com.soda.web.response.LinksResponse;
import com.soda.web.response.ProjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/projects")
public class ProjectController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project addProject(
            @PathVariable Long projectId,
            @RequestBody CreateProjectRequest createProjectRequest,
            HttpServletRequest response
    ) {
        return null;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectResponse getProject(
            @PathVariable Long projectId
    ){
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LinksResponse updateProject(
            @PathVariable Long projectId,
            @RequestBody ModifyProjectRequest modifyProjectRequest
    ) {
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LinksResponse deleteProject(
            @PathVariable Long ProjectId
    ) {
        return null;
    }
}
