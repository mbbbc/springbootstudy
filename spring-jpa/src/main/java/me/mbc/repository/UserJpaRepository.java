package me.mbc.repository;

import me.mbc.entity.extend.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface UserJpaRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Modifying
    @Query("UPDATE User u SET u.age = :age  WHERE u.name = :name")
    @Transactional
    void updateAgeByName(@Param("name") String name, @Param("age") Integer age);
}
