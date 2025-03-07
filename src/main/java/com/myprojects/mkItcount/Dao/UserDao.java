package com.myprojects.mkItcount.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myprojects.mkItcount.Entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Integer>{

	UserEntity findByUsername(String username);
}
