package com.capgemini.go.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.dto.LoginRequestDto;
import com.capgemini.go.exception.UserNotFoundException;
import com.capgemini.go.model.CustomerModel;
import com.capgemini.go.model.UserModel;
import com.capgemini.go.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserModel addUser(UserModel user) {
		return userRepo.save(user);
	}

	@Override
	public UserModel loginUser(LoginRequestDto user) throws UserNotFoundException {
		Optional<UserModel> foundUser = userRepo.findByUserName(user.getUserName());
		if(foundUser.isPresent()) {
			if((foundUser.get().getUserPassword().equals(user.getPassword()))) {
				return foundUser.get();
			} else {
				throw new UserNotFoundException("Password does not match! Try again.");
			}
		} else {
			throw new UserNotFoundException("UserName not Found! Try again or Create a new Account");
		}
	}

	@Override
	public List<UserModel> getAllUsers() {
		return (List<UserModel>) userRepo.findAll();
	}

	@Override
	public CustomerModel getCustomerByUserId(Integer userId) {
		Optional<UserModel> optUser = userRepo.findById(userId);
		if(optUser.isPresent()) {
			UserModel user = optUser.get();
			return user.getCustomer();
		}
		return null;
	}

}
