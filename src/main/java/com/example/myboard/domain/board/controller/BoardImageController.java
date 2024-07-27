package com.example.myboard.domain.board.controller;

import com.example.myboard.domain.board.dto.response.BoardImageResponse;
import com.example.myboard.domain.board.service.BoardImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class BoardImageController {


    private final BoardImageService boardImageService;
    private final ResourceLoader resourceLoader;

    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadTempImage(MultipartFile file) throws Exception {
        String imgUrl = boardImageService.uploadTempImage(file);
        return ResponseEntity.ok().body(imgUrl);
    }

    @GetMapping("/image/{fileId}")
    public ResponseEntity<?> serveFile(@PathVariable Long fileId){
        try {
            String path = boardImageService.load(fileId);
            Resource resource = resourceLoader.getResource("file:"+path);
            return ResponseEntity.ok().body(resource);
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
