package me.mbc.repository;

import me.mbc.entity.extend.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserJpaRepository {
    @Autowired
    UserJpaRepository userJpaRepository;



    /**
     * 一、QueryByExampleExecutor 的特点及约束
     * 1. 支持动态查询:即支持查询条件个数不固定的情况
     *
     * 2. 不支持过滤条件分组：即不支持过滤条件用 or（或）来连接，所有的过滤查件，都是简单一层的用 and（并且）连接
     *
     * 3. 仅支持字符串的开始/包含/结束/正则表达式匹配和其他属性类型的精确匹配,没办法同时对一个属性传入两个过滤值。
     *  例如要查询某个时间段内添加的客户，对应的属性是 addTime，需要传入“开始时间”和“结束时间”两个条件值，
     *  而这种查询方式没有存两个值的位置，所以就没办法完成这样的查询
     *
     *二、QueryByExampleExecutor 使用场景 & 实际的使用
     * 使用一组静态或动态约束来查询数据存储、频繁重构域对象，
     * 而不用担心破坏现有查询、简单的查询的使用场景
     */
    @Test
    public void test1(){
        User user = new User();
        user.setName("test3").setEmail("FmlWRf@qq.com");
        ExampleMatcher matcher =
                ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withIgnorePaths("age"); //忽略基本类型,因为基本类型存在默认值
        Example<User> ex = Example.of(user, matcher);
        List<User> all = userJpaRepository.findAll(ex);
        for (User user1 : all){
            System.out.println(user1);
        }
    }

    @Test
    public void test2(){
        User user = new User();
        user.setName("test3").setMoney(50);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher(User.Fields.name, ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnoreCase(true)
                .withIgnorePaths(User.Fields.age);
        Example<User> of = Example.of(user, exampleMatcher);
        List<User> all = userJpaRepository.findAll(of);
        all.forEach(System.out::println);
    }

    @Test
    public void test3(){
        User user = new User();
        user.setAge(3);
        Example<User> of = Example.of(user);
        List<User> all = userJpaRepository.findAll(of);
        all.forEach(System.out::println);
    }

    /**
     * 查询值为null的数据
     */
    @Test
    public void test4(){
        User user = new User();
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIncludeNullValues()
                .withIgnorePaths(User.Fields.age, User.Fields.email, User.Fields.id,
                        User.Fields.name);
        Example<User> of = Example.of(user, exampleMatcher);
        List<User> all = userJpaRepository.findAll(of);
        all.forEach(System.out::println);
    }
}
