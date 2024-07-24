package com.example.myboard.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    //BOARD
    BOARD_NOT_FOUNT(HttpStatus.NOT_FOUND,"존재하지 않는 게시글 입니다."),

    //5XX
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"서버 내부 에러");


    private final HttpStatus httpStatus;
    private final String message;

    ErrorCode(HttpStatus httpStatus,String message){
        this.httpStatus=httpStatus;
        this.message=message;
    }
}
