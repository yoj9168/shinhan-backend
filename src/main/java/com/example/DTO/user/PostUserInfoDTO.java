package com.example.DTO.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostUserInfoDTO {
    private final String userName;
    private final String password;
    private final String role;
}
