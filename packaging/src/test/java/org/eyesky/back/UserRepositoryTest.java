package org.eyesky.back;

import lombok.extern.slf4j.Slf4j;
import org.eyesky.back.repository.UserRepository;
import org.eyesky.back.repository.entity.JpaUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Test
    public void testCreateUser() {
        JpaUser user = new JpaUser();
        user.setEmail("user@gmail.com");
        user.setPassword("user2020");
        user.setFirstName("user");
        user.setLastName("user");
        JpaUser savedUser = repo.save(user);
        JpaUser existUser = repo.findById(savedUser.getId()).get();
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
        repo.delete(user);
    }
}
