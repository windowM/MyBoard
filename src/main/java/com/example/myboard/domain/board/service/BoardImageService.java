package com.example.myboard.domain.board.service;

import com.example.myboard.domain.board.entity.BoardImage;
import com.example.myboard.domain.board.repository.BoardImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardImageService {

    @Value("${file.dir}")
    private String imageLocation;
    private final BoardImageRepository boardImageRepository;

    public String uploadTempImage(MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new Exception("파일이 없다.");
        }
        String saveFileName = fileSave(imageLocation, file);
        BoardImage boardImage = BoardImage.builder()
                .originalName(file.getOriginalFilename())
                .path(imageLocation + "/" + saveFileName)
                .saveName(saveFileName)
                .build();

        boardImageRepository.save(boardImage);
        return "/image/" + boardImage.getId();
    }

    public String fileSave(String rootLocation, MultipartFile file) throws IOException {
        File uploadDir = new File(rootLocation);

        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String saveFileName = UUID.randomUUID().toString() + file.getOriginalFilename();
        File saveFile = new File(rootLocation, saveFileName);
        FileCopyUtils.copy(file.getBytes(), saveFile);

        return saveFileName;
    }

    public String load(Long fileId) {
        return boardImageRepository.findById(fileId).get().getPath();
    }
}
