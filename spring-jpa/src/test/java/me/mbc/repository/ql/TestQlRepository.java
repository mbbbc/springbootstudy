package me.mbc.repository.ql;

import me.mbc.entity.extend.User;
import me.mbc.repository.extend.UserCrudRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestQlRepository {

    @Autowired
    UserCrudRepository userRepository;


    @Test
    public void testFindByEmail(){
        User user = userRepository.findByEmail("132@qq.com");
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
        List<User> list = userRepository.findByNameStartingWith("test");
        System.out.println(list);
    }

    @Test
    public void testFindUserByName(){
        User user = userRepository.findUserByName("test1");
        System.out.println(user);
    }

    @Test
    public void testFindUserAndSort(){
        List<User> byAndSort = userRepository.findByAndSort("test", Sort.by("name"));
        for (User user : byAndSort){
            System.out.println(user);
        }
    }

    /**
     * Sort expression 'LENGTH(name): ASC' must only contain property references or aliases used in the select clause.
     * If you really want to use something other than that for sorting, please use JpaSort.unsafe(…)!
     * 在排序实例中实际使用的属性需要与实体模型里面的字段相匹配，这意味着它们需要解析为查询中使用的属性或别名。
     */
    @Test
    public void testFindUserAndSort1(){
        List<User> byAndSort = userRepository.findByAndSort("test", Sort.by("LENGTH(u.name)"));
        for (User user : byAndSort){
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserAndSort2(){
        List<User> byAndSort = userRepository.findByAndSort("test", JpaSort.unsafe("LENGTH(u.name)"));
        for (User user : byAndSort){
            System.out.println(user);
        }
    }

    /**
     * 在排序实例中实际使用的属性需要与实体模型里面的字段相匹配，
     * 这意味着它们需要解析为查询中使用的属性或别名。
     */
    @Test
    public void testFindUserAndSort3(){
        List<Object[]> byAndSort = userRepository.findByAsArrayAndSort("test", Sort.by("n_len"));
        for (Object[] user : byAndSort){
            for(Object obj : user){
                System.out.println("--------");
                System.out.print(obj);
                System.out.println("--------");
            }
        }
    }

    /**
     * 测试分页1
     */
    @Test
    public void testFindUserAndPage(){
        Page<User> page = userRepository.findByNameAndPage("test", PageRequest.of(1 - 1, 20, Sort.by("name")));
        for(User user : page){
            System.out.println(user);
        }
    }


    /**
     * 测试分页2
     */
    @Test
    public void testFindUserAndPageUseSql(){
        Page<User> page = userRepository.findByNameAndPageUseSql("test", PageRequest.of(1 - 1, 20, Sort.by("name")));
        for(User user : page){
            System.out.println(user);
        }
    }

    /**
     * 测试@Param的用法
     */
    @Test
    public void testParam(){
        List<User> list = userRepository.findUserByEmailAndName("test1", "132@qq.com");
        for(User user : list){
            System.out.println(user);
        }

    }

    /**
     * 测试在@Query中使用SPEL
     */
    @Test
    public void testUseSpelOnQuery(){
        List<User> list = userRepository.findUserByNameUserSpel("test");
        for (User user : list){
            System.out.println(user);
        }
    }

    /**
     * 测试@Modify
     */
    @Test
    public void testUpdateUserEmailByName(){
        int count = userRepository.UpdateUserEmailByName("test1","test1@qq.com");
        System.out.println("------------------");
        System.out.println("count = " + count);
    }
    @Test
    public void testDeleteUserByName(){
        int count = userRepository.deleteUserByName("test2");
        System.out.println("------------------");
        System.out.println("count = " + count);
    }


}
