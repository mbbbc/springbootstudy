package me.mbc.dao;

import org.springframework.data.repository.query.Param;

public interface UserDao {

    void updateEmailByName(String name, String email);
}
