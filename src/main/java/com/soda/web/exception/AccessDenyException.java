package com.soda.web.exception;

public class AccessDenyException extends RuntimeException{
    public AccessDenyException() {
        super("수정 및 접근 권한이 없습니다.");
    }

}
