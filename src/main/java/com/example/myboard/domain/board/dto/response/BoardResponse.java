package com.example.myboard.domain.board.dto.response;

import com.example.myboard.domain.board.entity.Board;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public record BoardResponse(
        Long id,
        String title,
        String content,
        Long viewCount,
        String memberEmail,
        LocalDate createdAt,
        LocalDate updatedAt,
        List<BoardImageResponse> images,
        List<BoardCommentResponse> comments
) {

    public static BoardResponse fromEntity(Board board,Boolean isDetail) {
        String content = Optional.ofNullable(board.getContent()).orElse("내용이 없습니다.");
        LocalDate updatedAT = Optional.ofNullable(board.getUpdatedAt())
                .map(LocalDateTime::toLocalDate)
                .orElse(null);

        if(!isDetail){
            return new BoardResponse(
                    board.getId(),
                    board.getTitle(),
                    content,
                    board.getViewCount(),
                    board.getMember().getEmail(),
                    board.getCreatedAt().toLocalDate(),
                    updatedAT,
                    null,
                    null
            );
        }

        return new BoardResponse(
                board.getId(),
                board.getTitle(),
                content,
                board.getViewCount(),
                board.getMember().getEmail(),
                board.getCreatedAt().toLocalDate(),
                updatedAT,
                board.getBoardImages().stream().map(BoardImageResponse::fromEntity).toList(),
                board.getBoardComments().stream().map(BoardCommentResponse::fromEntity).toList()
        );
    }
}
