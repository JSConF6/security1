package com.cos.security1.controller;

import com.cos.security1.model.User;
import com.cos.security1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // View를 리턴하겠다!!!
public class indexController {

    @Autowired
    private UserRepository userRepository;

    // localhost:8080/
    // localhost:8080
    @GetMapping({"", "/"})
    public String index(){
        // 머스테치 기본폴더 src/main/resources/
        // 뷰리졸버 설정 : templates (prefix) .mustache (suffix) 생략가능!!
        return "index"; // src/main/resources/templates/index.mustache
    }

    @GetMapping("/user")
    public @ResponseBody String user(){
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager(){
        return "manager";
    }

    // 스프링 시큐리티가 해당주소를 낚아챈다. - SecurityConfig 파일 생성 후 작동안함.
    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/join")
    public @ResponseBody String join(User user){
        System.out.println(user);
        user.setRole("ROLE_USER");
        userRepository.save(user);// 회원가입 잘됨. 비밀번호 : 1234 => 시큐리티로 로그인을 할 수 없음. 이유는 패스워드가 암호화가 안되있어서
        return "join";
    }
}