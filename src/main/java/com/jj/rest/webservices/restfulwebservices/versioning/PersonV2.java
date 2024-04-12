package com.jj.rest.webservices.restfulwebservices.versioning;

// 두 번째 버전의 Person 정보를 담는 PersonV2 클래스
public class PersonV2 {
    private Name name;

    public PersonV2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "name=" + name +
                '}';
    }
}

