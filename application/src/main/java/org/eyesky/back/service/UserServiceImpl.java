package org.eyesky.back.service;

import org.eyesky.back.repository.RoleRepository;
import org.eyesky.back.repository.UserRepository;
import org.eyesky.back.repository.entity.JpaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


//    @Override
////    @Transactional(value = "transactionManager")
//    @Transactional(Transactional.TxType.SUPPORTS)
//    public JpaUser updateExistingUser(JpaUser user, OAuth2UserInfo oAuth2UserInfo) {
//        return null;
//    }


    @Override
    public Optional<JpaUser> findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
        return null;
    }

    @Override
    public Optional<JpaUser> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public JpaUser saveUser(JpaUser jpaUser) {
        return userRepository.save(jpaUser);
    }

    @Override
    public Boolean checkIfMailExists(String userEmail) {
        return this.userRepository.findByEmail(userEmail).isPresent();
    }


}
