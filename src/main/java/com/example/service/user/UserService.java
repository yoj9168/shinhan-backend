package com.example.service.user;

import com.example.DTO.user.PostUserInfoDTO;
import com.example.DTO.user.ResponseUserDTO;
import com.example.domain.entity.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public void join(PostUserInfoDTO postUserInfoDTO){
        User user = new User(
                postUserInfoDTO.getUserName(),
                passwordEncoder.encode(postUserInfoDTO.getPassword()),
                postUserInfoDTO.getRole()
        );
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        return ResponseUserDTO.of(user);
    }
}
