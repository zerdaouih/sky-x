package org.eyesky.back.service.dto;

import java.util.List;

public class UserInfo {
    private String id, displayName, email;
    private List<String> roles;

    public UserInfo(String id, String displayName, String email, List<String> roles) {
        this.id = id;
        this.displayName = displayName;
        this.email = email;
        this.roles = roles;
    }
}
