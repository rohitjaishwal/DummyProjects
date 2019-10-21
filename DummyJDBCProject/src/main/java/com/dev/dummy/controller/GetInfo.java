package com.dev.dummy.controller;

import java.util.Scanner;

import com.dev.dummy.bean.UserBeanLombok;
import com.dev.dummy.factory.UserFactory;
import com.dev.dummy.services.UserServices;
import com.dev.dummy.services.UserValidation;

public class GetInfo {

	public static void main(String[] args) {
		UserServices us = UserFactory.getServiceImplInstance();
		UserValidation uv = UserFactory.getValidationInstance();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Id......");
		String userid = sc.nextLine();
		if (uv.idValidation(userid)) {
			UserBeanLombok user = us.getInfo(Integer.parseInt(userid));
			if (user != null) {
				System.out.println(user);
			} else {
				System.out.println("Something Went Wrong....");
			}
		} else {
			System.out.println("Enter Valid Id....");
		}
		sc.close();
	}

}
