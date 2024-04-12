package com.jj.rest.webservices.restfulwebservices.versioning;

// 첫 번째 버전의 Person 정보를 담는 PersonV1 클래스
public class PersonV1 {
    private String name;

    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "name='" + name + '\'' +
                '}';
    }
}
