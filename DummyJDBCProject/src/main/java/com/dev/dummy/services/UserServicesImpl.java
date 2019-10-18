package com.dev.dummy.services;

import java.util.List;

import com.dev.dummy.bean.UserBeanLombok;
import com.dev.dummy.dao.UserDAO;
import com.dev.dummy.factory.UserFactory;

public class UserServicesImpl implements UserServices {
	UserDAO dao = UserFactory.getDAOImplInstance();

	@Override
	public List<UserBeanLombok> getAllInfo() {
		return dao.getAllInfo();
	}

	@Override
	public UserBeanLombok getInfo(int userid) {
		return dao.getInfo(userid);
	}

	@Override
	public boolean insertUser(UserBeanLombok user) {
		return dao.insertUser(user);
	}

}
