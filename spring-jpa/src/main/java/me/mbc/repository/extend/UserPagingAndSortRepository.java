package me.mbc.repository.extend;

import me.mbc.entity.extend.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPagingAndSortRepository extends PagingAndSortingRepository<User, Integer> {


}
