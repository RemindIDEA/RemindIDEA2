package com.example.login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private String pw;
    private String email;
    protected Member(){}

    public Member(String username) {
        this.username = username;
    }
}
