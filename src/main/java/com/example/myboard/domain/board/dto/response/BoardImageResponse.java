package com.example.myboard.domain.board.dto.response;

import com.example.myboard.domain.board.entity.BoardImage;

public record BoardImageResponse (
        Long id,
        String originalName,
        String saveName,
        Integer boardId
) {

    public static BoardImageResponse fromEntity(BoardImage boardImage){
        return new BoardImageResponse(
                boardImage.getId(),
                boardImage.getOriginalName(),
                boardImage.getSaveName(),
                boardImage.getBoardId()
        );
    }
}
