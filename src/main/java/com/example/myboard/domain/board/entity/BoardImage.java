package com.example.myboard.domain.board.entity;

import com.example.myboard.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class BoardImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originalName;
    private String path;
    private String saveName;
    @Column(name = "board_id")
    private Long boardId;

    @Builder
    private BoardImage(String originalName,String path, String saveName, Long boardId) {
        this.originalName = originalName;
        this.path=path;
        this.saveName = saveName;
        this.boardId = boardId;
    }
}
