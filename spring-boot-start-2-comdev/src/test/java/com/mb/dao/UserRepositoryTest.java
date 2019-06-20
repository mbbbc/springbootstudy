package com.mb.dao;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mb.entity.User;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void test() {
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(new Date());
		
		//使用save保存记录
//		userRepository.save(new User("aa1", "aa", "aa@126.com", "aa123456", formattedDate));
//		userRepository.save(new User("bb2", "bb", "bb@126.com", "bb123456", formattedDate));
//		userRepository.save(new User("cc3", "cc", "cc@126.com", "cc123456", formattedDate));
		
		//使用findAll()查出所有
		Assert.assertEquals(3, userRepository.findAll().size());
		//按条件查找
		Assert.assertEquals("bb2", userRepository.findByUserNameOrEmail("bb2", "bb@126.com").getUserName());
		//删除
		//userRepository.delete(userRepository.findByUserName("aa1"));
	}
}
