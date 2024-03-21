package com.example.login.repository;

import com.example.login.entity.Login;
import com.example.login.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,String> {
}
