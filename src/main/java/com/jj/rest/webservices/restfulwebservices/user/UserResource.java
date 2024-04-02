package com.jj.rest.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    /**
     * 새로운 사용자를 생성하는 메서드
     * 사용자 정보를 전달받아서 저장 후, 생성된 사용자 정보와 함께 201 Created 상태 코드를 반환
     */
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        // 사용자 정보를 저장
        User savedUser = service.save(user);

        // 생성된 사용자의 ID를 포함한 URI를 생성
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedUser.getId())
                        .toUri();

        // 생성된 URI와 함께 201 Created 상태 코드를 반환
        return ResponseEntity.created(location).build();
    }

}
