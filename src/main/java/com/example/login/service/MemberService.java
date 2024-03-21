package com.example.login.service;

import com.example.login.dto.LoginDTO;
import com.example.login.enums.LoginResult;

public interface MemberService {
    //회원가입
    void register(LoginDTO loginDTO);
    //회원정보 가져오기
    LoginDTO get(LoginDTO loginDTO);
    //로그인 하기전 정보 확인
    LoginResult loginValidate(LoginDTO loginDTO);


    //회원정보 수정
    void modify(LoginDTO loginDTO);
    //회원정보 삭제
    void remove(LoginDTO loginDTO);
}
