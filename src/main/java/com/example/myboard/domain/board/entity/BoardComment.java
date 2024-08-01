package com.example.myboard.domain.board.entity;

import com.example.myboard.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class BoardComment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commentMemberEmail;
    private String ParentMemberEmail;
    private String comment;
    @Column(nullable = false, name = "board_id")
    private Long boardId;
}
