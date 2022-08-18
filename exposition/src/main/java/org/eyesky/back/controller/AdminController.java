package org.eyesky.back.controller;

import lombok.extern.slf4j.Slf4j;
import org.eyesky.back.repository.RoleRepository;
import org.eyesky.back.repository.entity.JpaRole;
import org.eyesky.back.repository.entity.JpaUser;
import org.eyesky.back.repository.entity.RoleEnum;
import org.eyesky.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/test")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/admin/add")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public JpaUser addUser(@RequestBody JpaUser jpaUser) {
        if(userService.checkIfMailExists(jpaUser.getEmail())) {
            return null;
        }
        log.info(" add user  {} by admin...   ", jpaUser.getEmail());
        jpaUser.setPassword(passwordEncoder.encode(jpaUser.getPassword()));
        JpaUser addedUser = userService.saveUser(jpaUser);
        Set<JpaRole> roles = new HashSet<>();
        JpaRole role = roleRepository.findByName(RoleEnum.USER);
        roles.add(role);
        jpaUser.setRoles(roles);
        log.info(" user {} added succesfully.", jpaUser.getEmail());
        return userService.saveUser(jpaUser);
    }
}
