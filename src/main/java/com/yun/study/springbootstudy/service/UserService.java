package com.yun.study.springbootstudy.service;

import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yun.study.springbootstudy.entity.User;
import com.yun.study.springbootstudy.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User login(User user) throws Exception {
		User targetUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(Objects.isNull(targetUser)) throw new Exception();

		return targetUser.makeLoginResponse();
	}
}
