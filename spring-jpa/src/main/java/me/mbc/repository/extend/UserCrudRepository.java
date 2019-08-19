package me.mbc.repository.extend;

import me.mbc.entity.extend.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 4.分页查询
     */
    @Query(value = "select u from User u where u.name like ?1%")
    Page<User> findByNameAndPage(String name, Pageable pageable);

    /**
     * 4.1 使用sql的分页
     */
    @Query(value = "select * from user where name like ?1%/*#pageable#*/",
           countQuery = "select count(*) from user where name like ?1%",
            nativeQuery = true)
    Page<User> findByNameAndPageUseSql(String name, Pageable pageable);

    /**
     * @Param用法
     */
    @Query("select u from User u where u.name = :name and email = :email")
    List<User> findUserByEmailAndName(@Param("name") String name1, @Param("email") String email);

    /**
     * @Query中使用SPEL
     */
    @Query(value = "select u from #{#entityName} u where u.name like :name%")
    List<User> findUserByNameUserSpel(@Param("name") String name);

    /**
     * @Modify的使用
     */
    @Modifying
    @Transactional
    @Query(value = "update User u set u.email = :email where name = :name")
    int UpdateUserEmailByName(@Param("name") String name, @Param("email") String Email);

    @Modifying
    @Transactional
    @Query("delete from User u where u.name = :name")
    int deleteUserByName(@Param("name") String name);

    /**@Query 的优缺点与实战经验分享
     * （1）可以灵活快速的使用 JPQL 和 SQL
     （2）对返回的结果和字段记性自定义
     （3）支持连表查询和对象关联查询，可以组合出来复杂的 SQL 或者 JPQL
     （4）可以很好的表达你的查询思路
     （5）灵活性非常强，快捷方便

     缺点（1）不支持动态查询条件，参数个数如果是不固定的不支持
     （2）有些读者会将返回结果用 Map 或者 Object[] 数组接收结果，会导致调用此方法的开发人员不知道返回结果里面到底有些什么数据

     实战经验	（1）当出现很复杂的 SQL 或者 JPQL 的时候建议用视图
     （2）返回结果一定要用对象接收，最好每个对象里面的字段和你返回的结果一一对应
     （3）能用 JPQL 的就不要用 SQL
     */
}
