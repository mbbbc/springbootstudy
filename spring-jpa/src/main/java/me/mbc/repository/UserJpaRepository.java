package me.mbc.repository;

import me.mbc.entity.UserInfoEntity;
import me.mbc.entity.extend.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
