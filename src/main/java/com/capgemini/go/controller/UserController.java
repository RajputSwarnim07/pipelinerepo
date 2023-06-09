package com.capgemini.go.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.dto.LoginRequestDto;
import com.capgemini.go.exception.UserNotFoundException;
import com.capgemini.go.model.CustomerModel;
import com.capgemini.go.model.UserModel;
import com.capgemini.go.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userSer;
	
	//http://localhost:8080/adduser
	@PostMapping("/adduser")
	public UserModel addUser(@Valid @RequestBody UserModel user) {
	    return userSer.addUser(user);
	}
	
	//http://localhost:8080/loginuser
	@PostMapping("/loginuser")
	public UserModel loginUser(@Valid @RequestBody LoginRequestDto user) throws UserNotFoundException {
		return userSer.loginUser(user);
	}
	
	//http://localhost:8080/getallusers
	@GetMapping("/getallusers")
	public List<UserModel> getAllUsers() {
		return userSer.getAllUsers();
	}
	
	@GetMapping("/getcustbyuserid/{userId}")
	public CustomerModel getCustByUserId(@PathVariable("userId") Integer userId) {
		return userSer.getCustomerByUserId(userId);
	}
}
