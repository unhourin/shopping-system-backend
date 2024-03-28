package com.yun.study.springbootstudy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_info")
public class User implements Serializable {
	public static final int NormalUser = 1;
	public static final int DemoUser = 2;
	public static final int AdminUser = 3;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String id;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "nickname")
	private String nickname;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "email")
	private String email;

	@Column(name = "role")
	private Boolean role;

	@Column(name = "token")
	private String token;

	public User makeLoginResponse() {
    	this.password = null;
    	return this;
    }
}
