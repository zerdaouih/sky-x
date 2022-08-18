package org.eyesky.back;

import lombok.extern.slf4j.Slf4j;
import org.eyesky.back.config.service.CustomUserDetails;
import org.eyesky.back.config.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("")
public class AppController {

    @Autowired
    CustomUserDetailsService userDetailsService;

    @GetMapping("/api/secure/hello")
    public String publicPage(Authentication authentication) {
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        log.info(authentication.getAuthorities().toString());
        return " Hello " + user.getFullName() + "!!  with roles : " + authentication.getAuthorities().toString();
    }

    @GetMapping("")
    public String welcom() {
        return " Hello with google";
    }
    @GetMapping("user")
    public String user(Principal principal) {
        log.info("principal : {} ",principal);
        return " Hello with google " + principal;
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
//    @RolesAllowed(RoleEnum.ADMIN)
    @GetMapping("/api/secure/admin")
    public String privatePage() {
        return " Hello private !! ";
    }
}
