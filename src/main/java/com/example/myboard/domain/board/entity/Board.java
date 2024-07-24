package com.example.myboard.domain.board.entity;

import com.example.myboard.domain.member.entity.Member;
import com.example.myboard.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Long viewCount;
    private File file;
    @ManyToOne
    private Member member;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id")
    private List<BoardImage> boardImages;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id")
    private List<BoardComment> boardComments;
}