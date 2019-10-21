package com.dev.dummy.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dev.dummy.services.UserValidation;

public class UserValidationImpl implements UserValidation {

	Pattern pat = null;
	Matcher mat = null;
	
	@Override
	public boolean idValidation(String id) {

		pat = Pattern.compile("\\d{1,10}");
		mat = pat.matcher(id);
		if(mat.matches()) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean nameValidation(String name) {

		pat = Pattern.compile("\\w+\\s\\w+");
		mat = pat.matcher(name);
		if(mat.matches()) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean emailValidation(String email) {

		pat = Pattern.compile("\\w+\\W\\w+\\@\\w+\\.\\w+");
		mat = pat.matcher(email);
		if(mat.matches()) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean passValidation(String pass) {

		pat = Pattern.compile("\\w+");
		mat = pat.matcher(pass);
		if(mat.matches()) {
			return true;
		}
		return false;
	}
}
