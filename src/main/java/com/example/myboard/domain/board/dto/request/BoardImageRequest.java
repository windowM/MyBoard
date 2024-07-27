package com.example.myboard.domain.board.dto.request;

import com.example.myboard.domain.board.entity.BoardImage;

public record BoardImageRequest(
        String originalName,
        String saveName,
        Long boardId
) {

    public BoardImage toEntity(){
        return BoardImage.builder()
                .originalName(originalName)
                .saveName(saveName)
                .boardId(boardId)
                .build();
    }
}
