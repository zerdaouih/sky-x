package org.eyesky.back.controller;

import lombok.extern.slf4j.Slf4j;
import org.eyesky.back.controller.request.SignupRequest;
import org.eyesky.back.controller.response.MessageResponse;
import org.eyesky.back.repository.RoleRepository;
import org.eyesky.back.repository.entity.JpaRole;
import org.eyesky.back.repository.entity.JpaUser;
import org.eyesky.back.repository.entity.RoleEnum;
import org.eyesky.back.service.UserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/register")
@Slf4j
public class RegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping()
    public ResponseEntity<?> registerUser(@Valid @RequestBody @NotNull SignupRequest signUpRequest) {
        if (userService.checkIfMailExists(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already taken!"));
        }
        // Create new user's account
        JpaUser user = new JpaUser();
        user.setEmail(signUpRequest.getEmail());
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        Set<JpaRole> roles = new HashSet<>();
        JpaRole userRole = roleRepository.findByName(RoleEnum.USER);
        roles.add(userRole);
        user.setRoles(roles);
        userService.saveUser(user);
        return ResponseEntity.ok(new
                MessageResponse("User registered successfully!"));
    }

}
