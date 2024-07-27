package com.example.myboard.domain.board.controller;


import com.example.myboard.domain.board.dto.request.BoardCreateRequest;
import com.example.myboard.domain.board.exception.BoardNotFoundException;
import com.example.myboard.domain.board.service.BoardService;
import com.example.myboard.global.common.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("boards", boardService.allList());
        return "board_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable Long id) {
        try {
            model.addAttribute("board", boardService.getDetail(id));
            return "board_detail";
        } catch (BoardNotFoundException e) {
            MessageDto message = new MessageDto(e.getMessage(), "/list", RequestMethod.GET, null);
            return showMessageAndRedirect(message, model);
        }
    }

    @GetMapping("/create")
    public String createBoardForm() {
        return "board_create";
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody BoardCreateRequest boardCreateRequest) {
        Long id = boardService.create(boardCreateRequest, 1L);
        return ResponseEntity.ok().body("/detail/" + id);
    }

    private String showMessageAndRedirect(MessageDto messageDto, Model model) {
        model.addAttribute("params", messageDto);
        return "common/messageRedirect";
    }
}
