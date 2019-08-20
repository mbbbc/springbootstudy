package me.mbc.repository;

import me.mbc.entity.extend.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {


}
