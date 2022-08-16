package org.eyesky.back.controller;

import lombok.extern.slf4j.Slf4j;
import org.eyesky.back.repository.entity.JpaUser;
import org.eyesky.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/test")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/admin/add")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public JpaUser addUser(@RequestBody JpaUser jpaUser) {
        log.info(" add user  {} by admin...", jpaUser.getEmail());
        jpaUser.setPassword(passwordEncoder.encode(jpaUser.getPassword()));
        JpaUser addedUser = userService.saveUser(jpaUser);
        log.info(" user {} added succesfully.", jpaUser.getEmail());
        return userService.saveUser(jpaUser);
    }
}
