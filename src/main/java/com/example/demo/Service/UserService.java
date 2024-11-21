package com.example.demo.Service;

import com.example.demo.Entity.UserInfo;
import com.example.demo.Repository.UserInfoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public record UserService(UserInfoRepository repository,
                          PasswordEncoder passwordEncoder) {
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "Them thanh cong";
    }
}
