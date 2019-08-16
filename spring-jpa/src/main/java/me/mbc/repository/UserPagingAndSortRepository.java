package me.mbc.repository;

import me.mbc.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPagingAndSortRepository extends PagingAndSortingRepository<User, Integer> {


}
