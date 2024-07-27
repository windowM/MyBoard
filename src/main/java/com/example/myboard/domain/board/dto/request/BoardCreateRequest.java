package com.example.myboard.domain.board.dto.request;

import com.example.myboard.domain.board.entity.Board;
import com.example.myboard.domain.board.entity.BoardImage;
import com.example.myboard.domain.member.entity.Member;

import java.util.List;

public record BoardCreateRequest(
        String title,
        String content,
        String viewCount,
        Member member,
        List<BoardImageRequest> boardImages
) {
    public Board toEntity(Member member){
        List<BoardImage> images=null;
        if(boardImages!=null){
            images = boardImages.stream().map(BoardImageRequest::toEntity).toList();
        }
        return Board.builder()
                .title(title)
                .content(content)
                .viewCount(0L)
                .member(member)
                .boardImages(images)
                .boardComments(null)
                .build();
    }
}
