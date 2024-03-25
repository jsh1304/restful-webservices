package com.jj.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
    private String message;

    // 주어진 메시지로 HelloWorldBean 객체를 생성
    public HelloWorldBean(String message) {
        this.message = message;
    }

    // 현재 설정된 메시지를 반환
    public String getMessage() {
        return message;
    }

    // 현재 메시지를 설정
    public void setMessage(String message) {
        this.message = message;
    }

    // 객체의 문자열 표현을 반환
    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
