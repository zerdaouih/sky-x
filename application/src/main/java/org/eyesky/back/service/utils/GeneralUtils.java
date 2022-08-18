package org.eyesky.back.service.utils;

import org.eyesky.back.repository.entity.JpaRole;
import org.eyesky.back.repository.entity.JpaUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GeneralUtils {
    public static List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final Set<JpaRole> roles) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        JpaUser jpaUser = new JpaUser();
        for (JpaRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName().name()));
        }
        return authorities;
    }


//    public static UserInfo buildUserInfo(LocalUser localUser) {
//        List<String> roles = localUser.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
//        JpaUser user = localUser.getUser();
//        return new UserInfo(user.getId().toString(), user.getDisplayName(), user.getEmail(), roles);
//    }
}
