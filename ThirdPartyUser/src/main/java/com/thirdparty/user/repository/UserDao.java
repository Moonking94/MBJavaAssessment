package com.thirdparty.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thirdparty.user.model.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long>, UserDaoCustom {

	Optional<UserEntity> findByName(String name);
	
	Optional<UserEntity> findByEmail(String email);
	
}
