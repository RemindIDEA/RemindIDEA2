package com.example.login.service;

import com.example.login.dto.LoginDTO;
import com.example.login.entity.Login;
import com.example.login.enums.LoginResult;
import com.example.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private LoginRepository repository;


    @Override
    public void register(LoginDTO loginDTO) {
        Login login = Login.builder()
                .id(loginDTO.getId())
                .pw(loginDTO.getPw())
                .username(loginDTO.getUsername())
                .email(loginDTO.getEmail())
                .build();
        repository.save(login);
    }

    @Override
    public LoginDTO get(LoginDTO loginDTO) {
        Optional<Login> login = repository.findById(loginDTO.getId());
        LoginDTO loginDTO1 = new LoginDTO();
        loginDTO1.setId(login.get().getId());
        loginDTO1.setPw(login.get().getPw());
        loginDTO1.setUsername(login.get().getUsername());
        loginDTO1.setEmail(login.get().getEmail());
        return loginDTO1;
    }

    @Override
    public LoginResult loginValidate(LoginDTO loginDTO) {
        LoginResult result = null;
        try {
            Optional<Login> login = repository.findById(loginDTO.getId());
            if(login.get().getPw().equals(loginDTO.getPw())){
                result = LoginResult.SUCCESS;
            }else{
                result = LoginResult.PASSWORD_NOT_CORRECT;
            }
        }catch (Exception e){
            result = LoginResult.USER_NOT_FOUND;
        }

        return result;
    }

    @Override
    public void modify(LoginDTO loginDTO) {
        //새로 받은 정보를 다시 저장
        Login login = Login.builder()
                .id(loginDTO.getId())
                .pw(loginDTO.getPw())
                .username(loginDTO.getUsername())
                .email(loginDTO.getEmail())
                .build();
        repository.save(login);
    }

    @Override
    public void remove(LoginDTO loginDTO) {
        repository.deleteById(loginDTO.getId());
    }
}
