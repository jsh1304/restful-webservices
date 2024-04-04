package com.jj.rest.webservices.restfulwebservices;

import java.time.LocalDateTime;

public class ErrorDetails {

    // 예외 발생 시간
    private LocalDateTime timestamp;

    // 예외 메시지
    private String message;

    // 예외 상세 정보
    private String details;

    //ErrorDetails 클래스의 생성자
    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    // 예외 발생 시간을 반환
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // 예외 메시지를 반환
    public String getMessage() {
        return message;
    }

    // 예외 상세 정보를 반환
    public String getDetails() {
        return details;
    }

}
