package me.mbc.dao.impl;

import me.mbc.dao.UserDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void updateEmailByName(String name, String email) {
        String sql = "UPDATE user u SET u.email = '" + email + "' WHERE u.name = '" + name + "'";
        entityManager.createNativeQuery(sql).executeUpdate();
    }
}
