package me.mbc.repository;import me.mbc.entity.UserInfoEntity;import org.springframework.data.jpa.repository.JpaRepository;import org.springframework.data.jpa.repository.JpaSpecificationExecutor;import org.springframework.stereotype.Repository;@Repositoryinterface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer>,JpaSpecificationExecutor<UserInfoEntity> {}