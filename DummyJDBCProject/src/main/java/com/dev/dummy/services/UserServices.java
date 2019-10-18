package com.dev.dummy.services;

import java.util.List;

import com.dev.dummy.bean.UserBeanLombok;

public interface UserServices {
	public List<UserBeanLombok> getAllInfo();
	public UserBeanLombok getInfo(int userid);
	public boolean insertUser(UserBeanLombok user);
}
