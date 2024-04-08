package com.jj.rest.webservices.restfulwebservices.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {

    private Integer id;

    @Size(min=2) // 최소 2글자 이상
    private String name;

    @Past // 과거의 날짜여야 함
    private LocalDate birthday;

    // 사용자 객체를 생성하는 생성자
    public User(Integer id, String name, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    // 사용자 ID를 반환
    public Integer getId() {
        return id;
    }

    // 사용자 ID를 설정
    public void setId(Integer id) {
        this.id = id;
    }

    // 사용자 이름을 반환
    public String getName() {
        return name;
    }

    // 사용자 이름을 설정
    public void setName(String name) {
        this.name = name;
    }

    // 사용자 생일을 반환
    public LocalDate getBirthday() {
        return birthday;
    }

    // 사용자 생일을 설정
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    // 객체의 문자열 표현을 반환
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
