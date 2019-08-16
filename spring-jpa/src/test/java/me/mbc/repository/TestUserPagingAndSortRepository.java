package me.mbc.repository;

import me.mbc.entity.User;
import me.mbc.repository.UserPagingAndSortRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserPagingAndSortRepository {
    @Autowired
    private UserPagingAndSortRepository userPagingAndSortRepository;

    @Before
    public void batchSaveUser(){
        int len = 10;
        for(int i = 0; i < len; i++){
            userPagingAndSortRepository.save(new User(RandomStringUtils.randomAlphabetic(6),
                                    RandomStringUtils.randomAlphabetic(6) + "@qq.com"));
        }
    }


    @Test
    public void getAllUsersWithSort(){
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, User.Fields.name);
        Sort.Order order1 = new Sort.Order(Sort.Direction.ASC, User.Fields.email);
        Sort sort = Sort.by(order, order1);
        Iterable<User> all = userPagingAndSortRepository.findAll(sort);
        for (User user : all) {
            System.out.println(user);
        }
    }

}
