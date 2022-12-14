package com.examle.web4;

import com.examle.web4.repository.ResultRepository;
import com.examle.web4.repository.UserRepository;
import com.examle.web4.entity.Result;
import com.examle.web4.entity.User;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BDTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ResultRepository resultRepository;

    User user = new User("test123", "test123");

    @BeforeAll
    void addUser(){
        userRepository.save(user);
        Result result = new Result(1,1,1,true, LocalDateTime.now(),user);
        resultRepository.save(result);
    }

    @Test
    public void test1(){
        System.out.println(userRepository);
        userRepository.getByUsername(user.getUsername());
    }

    @Test
    public void test2(){
        System.out.println(resultRepository.save(new Result(1,1,1,true,LocalDateTime.now(), new User("123123","123123"))));
    }

    @Test
    public void test3() {
        resultRepository.deleteAllByUserId(userRepository.getByUsername(user.getUsername()).get().getId());
        System.out.println(resultRepository.findAll());
    }

}

