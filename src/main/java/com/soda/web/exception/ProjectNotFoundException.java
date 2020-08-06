package com.soda.web.exception;

public class ProjectNotFoundException extends RuntimeException{
    /**
     * 확인되지 않는 프로젝트 입니다.
     */
    public ProjectNotFoundException(){
        super("존재하지 않는 프로젝트입니다.");
    }
}
