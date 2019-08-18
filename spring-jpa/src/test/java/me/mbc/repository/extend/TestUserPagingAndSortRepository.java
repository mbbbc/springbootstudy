package me.mbc.repository.extend;

import me.mbc.entity.extend.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserPagingAndSortRepository {
    @Autowired
    private UserPagingAndSortRepository userPagingAndSortRepository;

    //@Before
    public void batchSaveUser(){
        int len = 10;
        for(int i = 0; i < len; i++){
            userPagingAndSortRepository.save(new User(RandomStringUtils.randomAlphabetic(6),
                                    RandomStringUtils.randomAlphabetic(6) + "@qq.com"));
        }
    }

    /**
     *  对查出来的列表进行排序
     */
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

    /**
     * 对查出来的列表进行分页
     */
    @Test
    public void getAllUsersWithPage(){
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, User.Fields.name);
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, User.Fields.email);
        Sort sort = Sort.by(order, order1);
        Page<User> all = userPagingAndSortRepository.findAll(PageRequest.of(2 - 1, 10, sort));
        for(User user : all){
            System.out.println(user);
        }
    }





}
