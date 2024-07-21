package com.example.myboard.domain.board.entity;

import lombok.Getter;

@Getter
public enum Category {
    BASIC(1),
    HEALTH(2),
    HUMOR(3);

    private final Integer num;
    Category(Integer num){
        this.num=num;
    }
}
