package org.eyesky.back.controller;

import lombok.extern.slf4j.Slf4j;
import org.eyesky.back.config.jwt.JwtUtils;
import org.eyesky.back.config.service.CustomUserDetails;
import org.eyesky.back.controller.request.LoginRequest;
import org.eyesky.back.controller.response.JwtResponse;
import org.eyesky.back.repository.RoleRepository;
import org.eyesky.back.repository.UserRepository;
import org.eyesky.back.repository.entity.JpaUser;
import org.eyesky.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/secure/login")
@Slf4j
public class LoginService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;


    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            log.info(" login >>> {}", userDetails.getUser().toString());

            List<String> roles = userDetails.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());

            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getUser().getId(),
                    userDetails.getUsername(),
                    roles));
        } catch (BadCredentialsException badCredentialsException) {
            return ResponseEntity.badRequest().body("authentication failed");
        }
    }


    @PostMapping("/checkmail")
    public ResponseEntity<Boolean> checkIfUserMailExists(@RequestBody String userEmail) {
        log.info(" check if user mail {} exists ...", userEmail);
        if (userEmail == null) return ResponseEntity.notFound().build();
        ;
        Boolean exixts = userService.checkIfMailExists(userEmail);
        log.info(" email {} existant ", exixts);
        return ResponseEntity.ok(exixts);
    }

}
