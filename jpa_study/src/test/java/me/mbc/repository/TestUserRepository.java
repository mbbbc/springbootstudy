package me.mbc.repository;

import me.mbc.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserRepository {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testSaveUser() {
        userRepository.save(new User("test2", "232@qq.com"));
    }

}
