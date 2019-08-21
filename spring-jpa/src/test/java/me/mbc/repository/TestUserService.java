package me.mbc.repository;

import me.mbc.entity.extend.User;
import me.mbc.service.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserService {

    @Autowired
    UserService userService;

    @Test
    public void test1(){
        Page<User> allUser = userService.findAllUser(2, 10);
        allUser.forEach(System.out::println);
    }

    @Test
    public void test2(){
        userService.updateAgeByName("test5", 30);
        //int i = 1 / 0;
    }

    @Test
    public void test3(){
        userService.updateEmailByName("test5", "test@163.com");
    }
}
