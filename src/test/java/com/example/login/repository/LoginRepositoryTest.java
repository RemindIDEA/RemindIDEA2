package com.example.login.repository;

import com.example.login.entity.Login;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class LoginRepositoryTest {
    @Autowired
    LoginRepository repository;

    @Test
    public void insert(){
        IntStream.rangeClosed(1,10).forEach(i->{
            Login login = Login.builder()
                    .id("user"+i)
                    .pw("pw"+i)
                    .email("userMail"+i+"@aaa.com")
                    .username("username"+i)
                    .build();
            repository.save(login);
        });
    }
}
