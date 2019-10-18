package com.dev.dummy.factory;

import com.dev.dummy.dao.UserDAO;
import com.dev.dummy.dao.UserDAOJDBCImpl;
import com.dev.dummy.services.UserServices;
import com.dev.dummy.services.UserServicesImpl;
import com.dev.dummy.services.UserValidation;
import com.dev.dummy.validation.UserValidationImpl;

public class UserFactory {
	private UserFactory() {
	}
	
	public static UserDAO getDAOImplInstance() {
		UserDAO dao = new UserDAOJDBCImpl();
		return dao;
	}
	
	public static UserServices getServiceImplInstance() {
		UserServices services = new UserServicesImpl();
		return services;
	}
	
	public static UserValidation getValidationInstance() {
		UserValidation validation = new UserValidationImpl();
		return validation;
	}
}
