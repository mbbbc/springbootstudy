package me.mbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseService<T, ID>  {

    @Autowired
    protected JpaRepository<T, ID> jpaRepository;

    @Autowired
    protected JpaSpecificationExecutor<T> jpaSpecificationExecutor;

    //Page<T> findAll(Pageable pageable)
    public Page<T> findAll(Integer page, Integer size){
        return jpaRepository.findAll(PageRequest.of(page - 1, size));
    }


}
