package com.capgemini.go.service;

import java.util.List;

import com.capgemini.go.dto.LoginRequestDto;
import com.capgemini.go.exception.UserNotFoundException;
import com.capgemini.go.model.CustomerModel;
import com.capgemini.go.model.UserModel;

public interface UserService {
	
	public UserModel addUser(UserModel user);
	
	public UserModel loginUser(LoginRequestDto user) throws UserNotFoundException;
	
	public CustomerModel getCustomerByUserId(Integer userId);
	
	public List<UserModel> getAllUsers();
}