package com.example.myboard.domain.board.repository;

import com.example.myboard.domain.board.entity.BoardImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardImageRepository extends JpaRepository<BoardImage,Long> {

}
