package me.mbc.repository.extend;

import me.mbc.entity.extend.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCrudRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);

    List<User> findByNameAndEmail(String name, String email);

    /**
     * 1.使用JPQL
     * @param email
     * @return
     */
    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);

    /**
     * 2. JPQL like查询
     * @param name
     * @return
     */
    @Query("select u from User u where u.name like ?1%")
    List<User> findByNameStartingWith(String name);

    /**
     * 3.使用sql查询，nativeQuery不支持直接 Sort 的参数查询
     * @param name
     * @return
     */
    @Query(value = "select u.* from user u where u.name = ?1", nativeQuery = true)
    User findUserByName(String name);

    @Query("select u from User u where u.name like ?1%")
    List<User> findByAndSort(String name, Sort sort);

    @Query("select u.id, LENGTH(u.name) as n_len from User u where u.name like ?1%")
    List<Object[]> findByAsArrayAndSort(String name, Sort sort);

}
