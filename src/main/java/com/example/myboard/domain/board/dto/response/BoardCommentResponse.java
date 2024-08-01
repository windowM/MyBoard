package com.example.myboard.domain.board.dto.response;

import com.example.myboard.domain.board.entity.BoardComment;

public record BoardCommentResponse(
        Long id,
        String commentMemberEmail,
        String ParentMemberEmail,
        String comment,
        Long boardId
) {

    public static BoardCommentResponse fromEntity(BoardComment boardComment){
        return new BoardCommentResponse(
                boardComment.getId(),
                boardComment.getCommentMemberEmail(),
                boardComment.getParentMemberEmail(),
                boardComment.getComment(),
                boardComment.getBoardId()
        );
    }
}
