package com.jj.rest.webservices.restfulwebservices;

import com.jj.rest.webservices.restfulwebservices.helloworld.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러 클래스
public class HelloWorldController {

    @GetMapping(path = "/hello-world") // "/hello-world" 경로에 대한 GET 요청을 처리
    public String helloWorld() {
        return "Hello World"; // "Hello World"라는 문자열을 반환
    }

    @GetMapping(path = "/hello-world-bean") // "/hello-world-bean" 경로에 대한 GET 요청을 처리
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World"); // "Hello World" 메시지를 가진 HelloWorldBean 객체를 생성하여 반환
    }

    @GetMapping(path = "/hello-world/path-variable/{name}") // "/hello-world/path-variable/{name}" 경로에 대한 GET 요청을 처리
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        // "Hello World {name}" 메시지를 가진 HelloWorldBean 객체를 생성하여 반환
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
