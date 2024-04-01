package com.jj.rest.webservices.restfulwebservices.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

// 사용자 정보에 대한 RESTful API 제공하는 컨트롤러 클래스
@RestController
public class UserResource {

    private UserDaoService service;

    // UserDaoService를 주입받는 생성자
    public UserResource(UserDaoService service){
        this.service = service;
    }

    // 모든 사용자 정보 반환
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    // 주어진 id에 대한 사용자 정보 반환
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }

    // 새로운 사용자 생성
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        service.save(user);
    }

}
