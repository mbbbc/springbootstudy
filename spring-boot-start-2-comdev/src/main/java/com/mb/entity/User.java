package com.mb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
	
	public User(String userName, String passWord, String email, String nickName, String regTime) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.nickName = nickName;
		this.regTime = regTime;
	}

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String userName;
	
	@Column(nullable = false)
	private String passWord;

	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = true, unique = true)
	private String nickName;

	@Column(nullable = false)
	private String regTime;
}
