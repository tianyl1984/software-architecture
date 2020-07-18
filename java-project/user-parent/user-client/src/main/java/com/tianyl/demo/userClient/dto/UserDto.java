package com.tianyl.demo.userClient.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

	private static final long serialVersionUID = -5880925194559439795L;

	private Long id;

	private String username;

	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
