package com.example.controller.user;

import com.example.DTO.user.PostUserInfoDTO;
import com.example.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api/v1/user/join")
    public void join(@RequestBody PostUserInfoDTO postUserInfoDTO){
        userService.join(postUserInfoDTO);
    }

    @GetMapping("/home")
    public String home(){
        return "HI~";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin만 접속가능한 화면에 들어왔네요!";
    }

    @GetMapping("/manager")
    public String manager(){
        return "매니저까지 접속 가능한 화면에 들어왔네요!";
    }
}
