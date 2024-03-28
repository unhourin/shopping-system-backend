package com.yun.study.springbootstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yun.study.springbootstudy.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByUsernameAndPassword(String username, String password);

}
