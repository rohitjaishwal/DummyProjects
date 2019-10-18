package com.dev.dummy.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserBeanLombok implements Serializable {
	
	public UserBeanLombok() {
		super();
	}
	private int userid;
	private String username;
	private String email;
	@ToString.Exclude private String password;
}
