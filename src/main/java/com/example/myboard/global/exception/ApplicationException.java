package com.example.myboard.global.exception;

public class ApplicationException extends RuntimeException{

    private final ErrorCode errorCode;

    public ApplicationException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ApplicationException(ErrorCode errorCode,String message){
        super(message);
        this.errorCode=errorCode;
    }

    @Override
    public String getMessage() {
        if(super.getMessage()==null){
            return errorCode.getMessage();
        }
        return super.getMessage();
    }
}
