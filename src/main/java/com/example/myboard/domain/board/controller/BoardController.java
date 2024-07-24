package com.example.myboard.domain.board.controller;


import com.example.myboard.domain.board.exception.BoardNotFoundException;
import com.example.myboard.domain.board.service.BoardService;
import com.example.myboard.global.common.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("boards", boardService.allList());
        return "board";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("board", boardService.getDetail(id));
            return "board_detail";
        } catch (BoardNotFoundException e) {
            MessageDto message = new MessageDto(e.getMessage(), "/list", RequestMethod.GET, null);
            return showMessageAndRedirect(message, model);
        }
    }

    private String showMessageAndRedirect(MessageDto messageDto, Model model) {
        model.addAttribute("params", messageDto);
        return "common/messageRedirect";
    }
}
