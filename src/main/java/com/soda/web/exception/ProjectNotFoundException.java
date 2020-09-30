package com.soda.web.exception;

public class ProjectNotFoundException extends RuntimeException{

    public ProjectNotFoundException(){
        super("존재하지 않는 프로젝트입니다.");
    }
}
