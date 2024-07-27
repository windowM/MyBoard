package com.example.myboard.domain.board.service;

import com.example.myboard.domain.board.dto.request.BoardCreateRequest;
import com.example.myboard.domain.board.dto.response.BoardResponse;
import com.example.myboard.domain.board.entity.Board;
import com.example.myboard.domain.board.exception.BoardNotFoundException;
import com.example.myboard.domain.board.repository.BoardRepository;
import com.example.myboard.domain.member.entity.Member;
import com.example.myboard.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<BoardResponse> allList() {
        return boardRepository.findAll()
                .stream()
                .map(board -> BoardResponse.fromEntity(board, false))
                .toList();
    }

    @Transactional(readOnly = true)
    public BoardResponse getDetail(Long id) {
        return BoardResponse.fromEntity(findById(id), true);
    }

    @Transactional(readOnly = true)
    public Board findById(Long id) {
        return boardRepository.findById(id).orElseThrow(BoardNotFoundException::new);
    }

    public Long create(BoardCreateRequest request, Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        Board board = request.toEntity(member);
        Board newBoard = boardRepository.save(board);
        return newBoard.getId();
    }
}
