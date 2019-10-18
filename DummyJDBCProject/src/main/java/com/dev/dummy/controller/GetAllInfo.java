package com.dev.dummy.controller;

import java.util.List;

import com.dev.dummy.bean.UserBeanLombok;
import com.dev.dummy.factory.UserFactory;
import com.dev.dummy.services.UserServices;

public class GetAllInfo {

	public static void main(String[] args) {
		UserServices us = UserFactory.getServiceImplInstance();
		List<UserBeanLombok> list = us.getAllInfo();
		if (list != null) {
			for (UserBeanLombok user : list) {
				System.out.println(user);
			}
		} else {
			System.out.println("Something Went Wrong...");
		}
	}
}
