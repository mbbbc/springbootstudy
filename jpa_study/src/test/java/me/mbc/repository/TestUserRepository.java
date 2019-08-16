package me.mbc.repository;

import me.mbc.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserRepository {

    @Autowired
    UserCrudRepository userRepository;

    @Test
    public void testSaveUser() {
        userRepository.save(new User("test2", "232@qq.com"));
    }

    @Test
    public void testFindByName(){
        List<User> list = userRepository.findByName("test1");
        System.out.println(list);
    }

    @Test
    public void testFindByNameAndEmail(){
        List<User> list = userRepository.findByNameAndEmail("test2", "232@qq.com");
        System.out.println(list);
    }

    @Test
    public void testDeleteById(){
        try {
            userRepository.deleteById(564L);
        } catch (Exception e){
            System.out.println("--------------------------");
            boolean test = e instanceof EmptyResultDataAccessException;
            System.out.println("test is " + test);
            if(e instanceof EmptyResultDataAccessException){
                String s= String.format("%s 找不到要刪除的数据 ", "testDeleteById");
                System.out.println(s);
            }
        }

    }

}
