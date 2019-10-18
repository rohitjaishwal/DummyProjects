package com.dev.dummy.services;

public interface UserValidation {
	public boolean idValidation(String id);
	public boolean nameValidation(String name);
	public boolean emailValidation(String email);
	public boolean passValidation(String pass);
}
