package me.mbc.repository;

import me.mbc.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCrudRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);

    List<User> findByNameAndEmail(String name, String email);
}
