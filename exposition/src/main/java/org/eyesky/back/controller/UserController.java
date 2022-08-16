package org.eyesky.back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

//    @GetMapping("/user/me")
//    @PreAuthorize("hasRole('USER')")
//    public ResponseEntity<?> getCurrentUser(LocalUser user) {
//        return ResponseEntity.ok(GeneralUtils.buildUserInfo(user));
//    }

//    @GetMapping("/all")
//    public ResponseEntity<?> getContent() {
//        return ResponseEntity.ok("Public content goes here");
//    }
//
//    @GetMapping("/user")
//    @PreAuthorize("hasRole('USER')")
//    public ResponseEntity<?> getUserContent() {
//        return ResponseEntity.ok("User content goes here");
//    }
//
//    @GetMapping("/admin")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<?> getAdminContent() {
//        return ResponseEntity.ok("Admin content goes here");
//    }
//
//    @GetMapping("/mod")
//    @PreAuthorize("hasRole('MODERATOR')")
//    public ResponseEntity<?> getModeratorContent() {
//        return ResponseEntity.ok("Moderator content goes here");
//    }
}
