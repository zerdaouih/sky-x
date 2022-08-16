package org.eyesky.back.service;

import org.eyesky.back.repository.entity.JpaUser;

import java.util.Optional;

public interface UserService {

//    public JpaUser updateExistingUser(JpaUser user, OAuth2UserInfo oAuth2UserInfo);

    public JpaUser findUserByEmail(String email);

    public Optional<JpaUser> findUserById(Long id);

    public JpaUser saveUser(JpaUser jpaUser);

    Boolean checkIfMailExists(String userEmail);
}
