package com.soda.web.controller;

import com.soda.web.domain.entity.Project;
import com.soda.web.response.ProjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/projects")
public class ProjectListContoller {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PagedModel<ProjectResponse> getProjects(
            Pageable pageable,
            PagedResourcesAssembler<Project> assembler
    ) {
        return null;
    }
}
