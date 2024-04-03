package com.jj.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    // 사용자 데이터를 저장하는 정적 리스트
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    // 초기 사용자 데이터 설정
    static {
        users.add(new User(++usersCount, "Kim", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Lee", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Mike", LocalDate.now().minusYears(20)));
    }

    // 모든 사용자 데이터를 반환
    public List<User> findAll() {
        return users;
    }

    // 새로운 사용자 정보를 저장
    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }


    // 주어진 id에 해당하는 사용자 데이터를 반환
    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
}
