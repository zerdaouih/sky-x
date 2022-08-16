package org.eyesky.back;

import lombok.extern.slf4j.Slf4j;
import org.eyesky.back.config.service.CustomUserDetails;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/secure")
public class AppController {

    @GetMapping("/")
    public String publicPage(Authentication authentication) {
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return " Hello " + user.getFullName() + "!!  with roles : ";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin")
    public String privatePage() {
        return " Hello private !! ";
    }
}
