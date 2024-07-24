package com.example.myboard.domain.board.service;

import com.example.myboard.domain.board.dto.response.BoardResponse;
import com.example.myboard.domain.board.entity.Board;
import com.example.myboard.domain.board.exception.BoardNotFoundException;
import com.example.myboard.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<BoardResponse> allList() {
        return boardRepository.findAll()
                .stream()
                .map(board->BoardResponse.fromEntity(board,false))
                .toList();
    }

    @Transactional(readOnly = true)
    public BoardResponse getDetail(Long id){
        return BoardResponse.fromEntity(findById(id),true);
    }

    @Transactional(readOnly = true)
    public Board findById(Long id){
        return boardRepository.findById(id).orElseThrow(BoardNotFoundException::new);
    }
}
