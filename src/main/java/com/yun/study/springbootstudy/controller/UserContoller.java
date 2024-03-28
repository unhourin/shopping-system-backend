package com.yun.study.springbootstudy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yun.study.springbootstudy.entity.User;
import com.yun.study.springbootstudy.service.UserService;

@CrossOrigin
@RestController
public class UserContoller {

	private UserService userService;

	public UserContoller(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/data")
	public ResponseEntity<Object> getData() {

		User user = new User();
		user.setNickname("111");
		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody User user) {

		Map<String, Object> resMap = new HashMap<String, Object>();

		try {
			User userInfo = userService.login(user);
			return new ResponseEntity<Object>(userInfo, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("ユーザーかパスワードが間違っています。", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
