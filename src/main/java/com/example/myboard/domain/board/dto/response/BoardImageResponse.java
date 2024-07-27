package com.example.myboard.domain.board.dto.response;

import com.example.myboard.domain.board.entity.BoardImage;

public record BoardImageResponse (
        Long id,
        String originalName,
        String saveName,
        Long boardId
) {

    public static BoardImageResponse fromEntity(BoardImage boardImage){
        if(boardImage==null){
            return null;
        }
        return new BoardImageResponse(
                boardImage.getId(),
                boardImage.getOriginalName(),
                boardImage.getSaveName(),
                boardImage.getBoardId()
        );
    }
}
