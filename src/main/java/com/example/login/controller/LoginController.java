package com.example.login.controller;

import com.example.login.dto.LoginDTO;
import com.example.login.enums.LoginResult;
import com.example.login.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/example")
@AllArgsConstructor
@Log4j2
public class LoginController {
    @Autowired
    private final MemberService memberService;

    @GetMapping({"/login","/loginForm"})
    public void goLogin(){}
    @GetMapping("/main")
    public void goMain(LoginDTO loginDTO, Model model){
        model.addAttribute("loginDTO",loginDTO);
    }


    @PostMapping("/login")
    public String getLogin(LoginDTO loginDTO, RedirectAttributes rttr){
        LoginResult result = memberService.loginValidate(loginDTO);
        if(result == LoginResult.SUCCESS){
            rttr.addFlashAttribute("loginDTO",loginDTO);
            return "redirect:/example/main";
        }else if(result == LoginResult.PASSWORD_NOT_CORRECT){
            rttr.addFlashAttribute("msg","비밀번호가 틀렸습니다.");
            return "redirect:/example/login";
        }else{
            rttr.addFlashAttribute("msg","회원정보가 없습니다. 회원가입 ㄱㄱ");
            return "redirect:/example/login";
        }
    }

    @PostMapping("/loginForm")
    public String resister(LoginDTO loginDTO){
        memberService.register(loginDTO);
        return "redirect:/example/login";
    }
    @GetMapping("/modify")
    public void getModify(LoginDTO loginDTO,Model model){
        model.addAttribute("loginDTO", memberService.get(loginDTO));
    }

    @PutMapping("/modify")
    public String modify(LoginDTO loginDTO,RedirectAttributes rttr){
        memberService.modify(loginDTO);
        rttr.addFlashAttribute("loginDTO",memberService.get(loginDTO));
        return "redirect:/example/main";
    }

    @DeleteMapping("/remove")
    public String removeLogin(LoginDTO loginDTO){
        memberService.remove(loginDTO);
        return "redirect:/example/login";
    }


}
