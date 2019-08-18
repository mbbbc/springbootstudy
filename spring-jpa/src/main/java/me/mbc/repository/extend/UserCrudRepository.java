package me.mbc.repository.extend;

import me.mbc.entity.extend.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCrudRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);

    List<User> findByNameAndEmail(String name, String email);
}
