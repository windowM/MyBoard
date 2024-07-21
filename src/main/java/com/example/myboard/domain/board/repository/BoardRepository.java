package com.example.myboard.domain.board.repository;

import com.example.myboard.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BoardRepository extends JpaRepository<Board,Long> {
    //등록, 수정, 삭제,


}
