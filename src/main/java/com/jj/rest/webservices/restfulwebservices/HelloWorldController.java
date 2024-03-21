package com.jj.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러 클래스
public class HelloWorldController {

    @GetMapping(path = "/hello-world") // "/hello-world" 경로에 대한 GET 요청을 처리
    public String helloWorld() {
        return "Hello World"; // "Hello World"라는 문자열을 반환
    }
}
