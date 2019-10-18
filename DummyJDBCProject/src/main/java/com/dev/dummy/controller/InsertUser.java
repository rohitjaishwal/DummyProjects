package com.dev.dummy.controller;

import java.util.Scanner;

import com.dev.dummy.bean.UserBeanLombok;
import com.dev.dummy.factory.UserFactory;
import com.dev.dummy.services.UserServices;
import com.dev.dummy.services.UserValidation;

public class InsertUser {

	public static void main(String[] args) {
		UserServices us = UserFactory.getServiceImplInstance();
		UserValidation uv = UserFactory.getValidationInstance();
		Scanner sc = new Scanner(System.in);
		UserBeanLombok user = new UserBeanLombok();
		
		System.out.println("enter userid...");
		String userid = sc.nextLine();
		if(uv.idValidation(userid)) {
			user.setUserid(Integer.parseInt(userid));
		}else {
			System.out.println("enter valid userid...");
			System.exit(0);
		}
		
		System.out.println("enter username...");
		String username = sc.nextLine();
		if(uv.nameValidation(username)) {
			user.setUsername(username);
		}else {
			System.out.println("enter valid username...");
			System.exit(0);
		}
		
		System.out.println("enter email...");
		String email = sc.nextLine();
		if(uv.emailValidation(email)) {
			user.setEmail(email);
		}else {
			System.out.println("enter valid email...");
			System.exit(0);
		}
		
		System.out.println("enter password");
		String password = sc.nextLine();
		if(uv.passValidation(password)) {
			user.setPassword(password);
		}else {
			System.out.println("enter valid password...");
			System.exit(0);
		}
		
		
		boolean b = us.insertUser(user);
		if(b) {
			System.out.println("User Inserted...");
		}else {
			System.out.println("Something Went Wrong...");
		}
		sc.close();
	}

}
