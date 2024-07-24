package com.example.myboard.global.common;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

public record MessageDto(
        String message,           // 사용자에게 전달할 메시지
        String redirectUri,          // 리다이렉트 URI
        RequestMethod method,        // HTTP 요청 메서드
        Map<String, Object> data    // 화면(View)으로 전달할 데이터(파라미터)
) {

    public static MessageDto messageDto(String message, String redirectUri, RequestMethod method, Map<String, Object> data){
        return new MessageDto(
                message,
                redirectUri,
                method,
                data
        );
    }
}
