package com.example.myboard.domain.board.exception;

import com.example.myboard.global.exception.ApplicationException;
import com.example.myboard.global.exception.ErrorCode;

public class BoardNotFoundException extends ApplicationException {
    public BoardNotFoundException() {
        super(ErrorCode.BOARD_NOT_FOUNT);
    }
}
