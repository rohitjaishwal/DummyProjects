package com.dev.dummy.dao;

import java.util.List;

import com.dev.dummy.bean.UserBeanLombok;

public interface UserDAO {
	public List<UserBeanLombok> getAllInfo();
	public UserBeanLombok getInfo(int userid);
	public boolean insertUser(UserBeanLombok user);
	public boolean deleteUser(int userid, String password);
}
