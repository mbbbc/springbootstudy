package me.mbc.service.impl;

import me.mbc.dao.UserDao;
import me.mbc.entity.extend.User;
import me.mbc.repository.UserJpaRepository;
import me.mbc.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService extends BaseService<User, Long>  {

    @Autowired
    UserDao userDao;

    @Autowired
    UserJpaRepository userJpaRepository;


    public Page<User> findAllUser(Integer page, Integer size){
        return findAll(page, size);
    }

    @Transactional
    public void updateEmailByName(String name, String email){
        userDao.updateEmailByName(name, email);
    }

    @Transactional
    public void updateAgeByName(String name, Integer age){
        userJpaRepository.updateAgeByName(name, age);
    }
}
