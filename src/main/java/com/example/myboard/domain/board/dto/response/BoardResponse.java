package com.example.myboard.domain.board.dto.response;

import com.example.myboard.domain.board.entity.Board;

import java.time.LocalDate;

public record BoardResponse(
        String title,
        Long viewCount,
        String memberEmail,
        LocalDate createdAt
) {

    public static BoardResponse fromEntity(Board board){
        return new BoardResponse(
                board.getTitle(),
                board.getViewCount(),
                board.getMember().getEmail(),
                board.getCreatedAt().toLocalDate()
        );
    }
}
