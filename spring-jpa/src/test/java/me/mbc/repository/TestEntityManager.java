package me.mbc.repository;

import me.mbc.entity.UserInfoEntity;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEntityManager {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void test1() {
        StringBuilder builder = new StringBuilder("select u.last_name, u.telephone from user_info u");
        javax.persistence.Query query = entityManager.createNativeQuery(builder.toString());
        query.setFirstResult(0).setMaxResults(10);
//        query.unwrap(NativeQuery.class).setResultTransformer(
//                Transformers.aliasToBean(UserInfoEntity.class)
//        );
        List resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }
}
